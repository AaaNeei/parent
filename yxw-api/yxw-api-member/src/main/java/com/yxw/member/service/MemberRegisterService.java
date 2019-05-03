package com.yxw.member.service;

import com.alibaba.fastjson.JSONObject;
import com.yxw.base.BaseResponse;
import com.yxw.in.StudentInDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/3  10:05
 * @Description: 游学网
 * @throws:
 */
@Api(tags = "会员注册接口")
@RequestMapping("/member")
public interface MemberRegisterService {

    @ApiOperation(value = "用户信息注册接口")
    @RequestMapping("/register")
    public BaseResponse<JSONObject> register(@RequestBody StudentInDTO student,
                                             @RequestParam("registerCode") String registerCode);
}
