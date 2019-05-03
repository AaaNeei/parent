package com.yxw.weixin.service.impl;

import com.yxw.base.BaseApiService;
import com.yxw.weixin.service.WeiXinService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeiXinServiceImpl extends BaseApiService implements WeiXinService {
	//@Value("${yxw.weixin.name}")
	private String name;

}
