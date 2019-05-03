package com.yxw.member.service;


import com.yxw.base.BaseResponse;
import com.yxw.in.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:阿倪
 * @Date: 2019/4/18 19:37
 * @Description:
 * @return:
 * @throws:
 */
@Api(tags = "会员服务接口")
@RequestMapping("/member")
public interface MemberService {

    /**
     * 校验用户手机号
     *
     * @param mobile
     * @return
     */
    @ApiOperation(value = "校验用户手机号")
    @PostMapping("/exitMobile")
    @ApiImplicitParam(paramType = "query", name = "mobile", dataType = "String", required = true, value = "用户手机号")
    public BaseResponse<Student> exitMobile(@RequestParam(value = "mobile") String mobile);

}
