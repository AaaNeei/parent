package com.yxw.web.feign;

import com.yxw.member.service.MemberRegisterService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/4  10:15
 * @Description: 游学网
 * @throws:
 */

@Component
@FeignClient("yxw-api-member")
public interface MemberRegisterServiceFeign extends MemberRegisterService {
}
