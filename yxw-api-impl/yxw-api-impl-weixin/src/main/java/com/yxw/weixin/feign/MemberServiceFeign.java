package com.yxw.weixin.feign;

import com.yxw.member.service.MemberService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/3  13:49
 * @Description: 游学网
 * @throws:
 */
@Component
@FeignClient("yxw-api-member")
public interface MemberServiceFeign extends MemberService {
}
