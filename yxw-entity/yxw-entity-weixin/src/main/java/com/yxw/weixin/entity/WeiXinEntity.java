package com.yxw.weixin.entity;

import java.io.Serializable;

/**
 * @param
 * @Description:
 * @Author: AaNeei
 * @Date: 2019/5/221:12
 * @throws:
 */
public class WeiXinEntity implements Serializable {
    private String id;
    private String addr;

    public WeiXinEntity(String id, String addr) {
        this.id = id;
        this.addr = addr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
