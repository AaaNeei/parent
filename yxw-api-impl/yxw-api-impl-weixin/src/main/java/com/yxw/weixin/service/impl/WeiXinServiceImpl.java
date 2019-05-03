package com.yxw.weixin.service.impl;

import com.yxw.base.BaseApiService;
import com.yxw.base.BaseResponse;
import com.yxw.weixin.entity.WeiXinEntity;
import com.yxw.weixin.service.WeiXinService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeiXinServiceImpl extends BaseApiService<WeiXinEntity> implements WeiXinService {
	//@Value("${yxw.weixin.name}")
	private String name;

	@Override
	public BaseResponse<WeiXinEntity> getApp() {
		// return setResultSuccess(new AppEntity("1111", "22222"));
		return setResultError("系统错误");
	}
	// 定义泛型T的有一定缺点：该接口统一返回一种类型

}
