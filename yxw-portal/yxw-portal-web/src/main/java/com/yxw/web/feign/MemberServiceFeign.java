package com.yxw.web.feign;

import com.yxw.member.service.MemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/4  11:16
 * @Description: 游学网
 * @throws:
 */
@FeignClient("yxw-api-member")
public interface MemberServiceFeign extends MemberService {
}
