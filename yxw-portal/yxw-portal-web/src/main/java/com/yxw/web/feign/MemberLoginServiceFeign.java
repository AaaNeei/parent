package com.yxw.web.feign;

import com.yxw.member.service.MemberLoginService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/4  10:58
 * @Description: 游学网
 * @throws:
 */
@Component
@FeignClient("yxw-api-member")
public interface MemberLoginServiceFeign extends MemberLoginService {
}
