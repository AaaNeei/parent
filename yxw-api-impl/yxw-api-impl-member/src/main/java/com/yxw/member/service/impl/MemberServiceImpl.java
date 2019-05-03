package com.yxw.member.service.impl;

import com.yxw.base.BaseApiService;
import com.yxw.base.BaseResponse;
import com.yxw.constants.Constants;
import com.yxw.in.StudentDO;
import com.yxw.member.mapper.StudentMapper;
import com.yxw.member.service.MemberService;
import com.yxw.out.StudentOutDTO;
import com.yxw.utils.GenerateToken;
import com.yxw.utils.TypeCastHelper;
import com.yxw.utils.YxwBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:阿倪
 * @Date: 2019/4/18 19:37
 * @Description:
 * @return:
 * @throws:
 */
@Service
@Slf4j
public class MemberServiceImpl extends BaseApiService<StudentOutDTO> implements MemberService {


    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private GenerateToken generateToken;

    @Override
    public BaseResponse<StudentOutDTO> exitMobile(@RequestParam(value = "mobile") String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return setResultError(Constants.HTTP_RES_CODE_601, "手机号不能为空!");
        }

        StudentDO student = studentMapper.exitMobile(mobile);
        if (student == null) {
            //用户不存在说明该手机号未被注册,可以使用
            return setResultError(Constants.HTTP_RES_CODE_602, "用户不存在!");
        }
        //student.setStuPassword(null);
        //用户存在,返回数据需要做脱敏处理,转dto
        StudentOutDTO studentOutDTO = YxwBeanUtils.doToDto(student, StudentOutDTO.class);
        return setResultSuccess(studentOutDTO);
    }

    @Override
    public BaseResponse<StudentOutDTO> getStudentByToken(@RequestParam("token") String token) {
        // 1.参数验证
        if (StringUtils.isEmpty(token)) {
            return setResultError("token不能为空!");
        }
        // 2.使用token向redis中查询userId
        //如果用户修改密码或者退出需要干掉redis的token
        String redisValue = generateToken.getToken(token);
        if (StringUtils.isEmpty(redisValue)) {
            return setResultError("token已经失效或者不正确");
        }
        Long stuId = TypeCastHelper.toLong(redisValue);
        // 3.根据userId查询用户信息
        StudentDO studentDO = studentMapper.findStudentByStuId(stuId);
        if (studentDO == null) {
            return setResultError("用户信息不存在!");
        }
        // 4.将Do转换为Dto
        StudentOutDTO doToDto = YxwBeanUtils.doToDto(studentDO, StudentOutDTO.class);
        return setResultSuccess(doToDto);
    }
}
