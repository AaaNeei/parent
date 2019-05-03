package com.yxw.weixin.service;

import com.yxw.base.BaseResponse;
import com.yxw.weixin.entity.WeiXinEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author: niping
 * @date: 2019/05/01  0001 15:42
 * @version V1.0
 * @description:
 */

@Api(tags = "微信服务接口")
public interface WeiXinService
{

    /**
     * 获取应用信息
     *
     * @return
     */
    @ApiOperation(value = "获取微信信息")
    @GetMapping("/getApp")
    public BaseResponse<WeiXinEntity> getApp();





}
