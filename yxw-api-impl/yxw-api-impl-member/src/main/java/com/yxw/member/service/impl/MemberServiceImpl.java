package com.yxw.member.service.impl;

import com.yxw.base.BaseApiService;
import com.yxw.base.BaseResponse;
import com.yxw.constants.Constants;
import com.yxw.in.Student;
import com.yxw.member.mapper.StudentMapper;
import com.yxw.member.service.MemberService;
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
public class MemberServiceImpl extends BaseApiService<Student> implements MemberService {


    @Autowired
    private StudentMapper studentMapper;

    @Override
    public BaseResponse<Student> exitMobile(@RequestParam(value = "mobile") String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return setResultError(Constants.HTTP_RES_CODE_601, "手机号不能为空!");
        }

        Student student = studentMapper.exitMobile(mobile);
        if (student == null) {
            //用户不存在说明该手机号未被注册,可以使用
            return setResultError(Constants.HTTP_RES_CODE_602, "用户不存在!");
        }
        //用户存在,返回数据需要做脱敏处理,建议转dto
        student.setStuPassword(null);
        return setResultSuccess(student);
    }
}
