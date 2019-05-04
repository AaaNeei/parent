package com.yxw.member.service;

import com.alibaba.fastjson.JSONObject;
import com.yxw.base.BaseResponse;
import com.yxw.in.StudentLoginDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/3  18:39
 * @Description: 游学网 用户登录
 * @throws:
 */
@Api(tags = "会员登陆服务")
@RequestMapping("/member")
public interface MemberLoginService {
    /**
     * 用户登录入口
     *
     * @param loginDTO
     * @return
     */
    @ApiOperation(value = "用户登陆接口")
    @RequestMapping("/login")
    public BaseResponse<JSONObject> login(@RequestBody StudentLoginDTO loginDTO);

    /**
     * 用户退出入口
     *
     * @param token
     * @return
     */
    @ApiOperation(value = "用户退出接口")
    @RequestMapping("/exit")
    public BaseResponse<JSONObject> exit(@RequestParam("token") String token);


}
