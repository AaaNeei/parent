package com.yxw.weixin.entity;

/**
 * @version V1.0
 * @author: niping
 * @date: 2019/05/01  0001 15:42
 * @description:
 */

public class WeiXinEntity
{
    /**
     * 应用id
     */
    private String appId;

    /**
     * 应用密钥
     */
    private String appSecret;

    public String getAppId()
    {
        return appId;
    }

    public void setAppId(String appId)
    {
        this.appId = appId;
    }

    public String getAppSecret()
    {
        return appSecret;
    }

    public WeiXinEntity(String appId, String appSecret)
    {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public void setAppSecret(String appSecret)

    {
        this.appSecret = appSecret;
    }
}
