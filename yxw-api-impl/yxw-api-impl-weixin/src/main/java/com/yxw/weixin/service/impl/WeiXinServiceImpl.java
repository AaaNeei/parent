package com.yxw.weixin.service.impl;

import com.yxw.weixin.entity.WeiXinEntity;
import com.yxw.weixin.service.WeiXinService;
import org.springframework.web.bind.annotation.RestController;


/**
 * @version V1.0
 * @author: niping
 * @date: 2019/05/01  0001 16:45
 * @description: 微信服务接口实现
 */

@RestController
public class WeiXinServiceImpl implements WeiXinService
{
    @Override
    public WeiXinEntity getApp()
    {
        return new WeiXinEntity("niping","游学网");
    }
}
