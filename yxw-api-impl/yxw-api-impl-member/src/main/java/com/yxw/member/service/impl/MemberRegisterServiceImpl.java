package com.yxw.member.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yxw.base.BaseApiService;
import com.yxw.base.BaseResponse;
import com.yxw.constants.Constants;
import com.yxw.in.StudentDO;
import com.yxw.in.StudentInDTO;
import com.yxw.member.feign.VerificaCodeServiceFeign;
import com.yxw.member.mapper.StudentMapper;
import com.yxw.member.service.MemberRegisterService;
import com.yxw.utils.MD5Util;
import com.yxw.utils.YxwBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/3  10:10
 * @Description: 游学网
 * @throws:
 */
@RestController
public class MemberRegisterServiceImpl extends BaseApiService<JSONObject> implements MemberRegisterService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private VerificaCodeServiceFeign verificaCodeServiceFeign;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse<JSONObject> register(@RequestBody StudentInDTO student,
                                             @RequestParam("registerCode") String registerCode) {
        //校验基础信息
        if (StringUtils.isEmpty(student.getStuUsername())) {
            return setResultError("用户名不能为空");
        }
        if (StringUtils.isEmpty(student.getStuPassword())) {
            return setResultError("密码不能为空");
        }
        if (StringUtils.isEmpty(student.getStuMobile())) {
            return setResultError("手机号不能为空");
        }
        if (StringUtils.isEmpty(registerCode)) {
            return setResultError("验证码不能为空");
        }
        //调用微信接口校验验证码
        BaseResponse<JSONObject> verificaWeixinCode = verificaCodeServiceFeign.verificaWeixinCode(student.getStuMobile(), registerCode);
        if (!Constants.HTTP_RES_CODE_200.equals(verificaWeixinCode.getRtnCode())) {
            return setResultError(verificaWeixinCode.getMsg());
        }

        //md5需要加盐
        String md5Pwd = MD5Util.MD5(student.getStuPassword());
        student.setStuPassword(md5Pwd);
        //dto 转 do
        StudentDO studentDO = YxwBeanUtils.dtoToDo(student, StudentDO.class);
        //存入数据库 do
        return studentMapper.register(studentDO) > 0 ? setResultSuccess("注册成功!") : setResultError("注册失败");
    }
}
