package com.yxw.member.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yxw.base.BaseApiService;
import com.yxw.base.BaseResponse;
import com.yxw.in.LoginDo;
import com.yxw.in.StudentDO;
import com.yxw.in.StudentLoginDTO;
import com.yxw.member.constant.MemberConstants;
import com.yxw.member.mapper.StudentMapper;
import com.yxw.member.mapper.StudentTokenMapper;
import com.yxw.member.service.MemberLoginService;
import com.yxw.utils.GenerateToken;
import com.yxw.utils.MD5Util;
import com.yxw.utils.RedisDataSourceTransaction;
import com.yxw.utils.YxwBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.TransactionStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/3  18:42
 * @Description: 游学网
 * @throws:
 */
@RestController
public class MemberLoginServiceImpl extends BaseApiService<JSONObject> implements MemberLoginService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentTokenMapper tokenMapper;
    /**
     * token操作redis工具类
     */
    @Autowired
    private GenerateToken generateToken;
    /**
     * 手动式事务实现
     * redis和数据库双重事务
     */
    @Autowired
    private RedisDataSourceTransaction redisDataSourceTransaction;

    @Value("member.login.type:android_pc_ios")
    private String memberLoginType;

    @Override
    public BaseResponse<JSONObject> login(@RequestBody StudentLoginDTO loginDTO) {

        // 1.验证参数
        String mobile = loginDTO.getStuMobile();
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }
        String password = loginDTO.getStuPassword();
        if (StringUtils.isEmpty(password)) {
            return setResultError("密码不能为空!");
        }
        String loginType = loginDTO.getLoginType();
        if (StringUtils.isEmpty(loginType)) {
            return setResultError("登陆类型不能为空!");
        }

        //登录设备限制
        if (!(memberLoginType.contains(loginType.toLowerCase()))) {
            return setResultError("登陆类型出现错误!");
        }

        // 设备信息
        String deviceInfor = loginDTO.getDeviceInfor();
        if (StringUtils.isEmpty(deviceInfor)) {
            return setResultError("设备信息不能为空!");
        }
        String newPassWord = MD5Util.MD5(password);
        loginDTO.setStuPassword(newPassWord);
        // 2.用户名称与密码登陆
        StudentDO studentDO = studentMapper.login(YxwBeanUtils.dtoToDo(loginDTO, StudentDO.class));
        if (studentDO == null) {
            return setResultError("用户名称与密码错误!");
        }

        //变更数据前同时开启redis和sql事务
        return transactionRedisAndSql(studentDO, loginDTO);
    }

    /**
     * 手动式事务
     * 数据库事务和redis事务处理
     *
     * @param studentDO
     * @param loginDTO
     * @return
     */
    private BaseResponse<JSONObject> transactionRedisAndSql(StudentDO studentDO, StudentLoginDTO loginDTO) {
        Integer stuId = studentDO.getStuId();
        String loginType = loginDTO.getLoginType();
        //3.查询上一次登录信息
        LoginDo studentTokenDo = tokenMapper.selectStudentByStuIdAndLoginType(stuId, loginType);
        TransactionStatus transactionStatus = null;
        try {
            transactionStatus = redisDataSourceTransaction.begin();
            if (studentTokenDo != null) {
                // 4.清除之前的token,需要考虑与数据库数据一致性和事务性
                String token = studentTokenDo.getToken();
                //removeToken在redis事务开启情况下为false,commit前未删除
                Boolean removeToken = generateToken.removeToken(token);
                Integer updateTokenAvailability = tokenMapper.updateTokenAvailability(token);
                if (!toDaoResult(updateTokenAvailability)) {
                    //修改状态失败,回滚
                    redisDataSourceTransaction.rollback(transactionStatus);
                    return setResultError("系统错误!");
                }
            }

            // 5. 生成新的token
            String token = generateToken.createToken(MemberConstants.MEMBER_TOKEN_KEY_PREFIX + loginType, stuId + "", MemberConstants.MEMBRE_LOGIN_TOKEN_TIMEOUT);
            LoginDo loginDo = new LoginDo();
            loginDo.setLoginType(loginDTO.getLoginType());
            loginDo.setDeviceInfor(loginDTO.getDeviceInfor());
            loginDo.setStuId(stuId + "");
            loginDo.setToken(token);
            // 6.存入在数据库中
            Integer insertStudentToken = tokenMapper.insertStudentToken(loginDo);
            if (!toDaoResult(insertStudentToken)) {
                //存入数据库失败,回滚
                redisDataSourceTransaction.rollback(transactionStatus);
            }
            JSONObject tokenData = new JSONObject();
            tokenData.put("token", token);
            //前面都没有问题在提交事务
            redisDataSourceTransaction.commit(transactionStatus);
            return setResultSuccess(tokenData);
        } catch (Exception e) {
            try {
                redisDataSourceTransaction.rollback(transactionStatus);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            return setResultError("系统错误!");
        }
    }
}

