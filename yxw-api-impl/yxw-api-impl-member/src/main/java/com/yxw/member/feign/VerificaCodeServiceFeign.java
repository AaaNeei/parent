package com.yxw.member.feign;

import com.yxw.weixin.service.VerificaCodeService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/3  14:25
 * @Description: 游学网
 * @throws:
 */
@FeignClient("yxw-api-weixin")
@Component
public interface VerificaCodeServiceFeign extends VerificaCodeService {
}
