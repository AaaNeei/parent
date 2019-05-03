package com.yxw.in;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/3  17:49
 * @Description: 游学网 登陆do对象
 * @throws:
 */
public class LoginDo implements Serializable {

    private static final long serialVersionUID = -5560855696011164608L;

    private Integer id;
    private String token;
    private String loginType;
    private String deviceInfor;
    private String isAvailability;
    private String stuId;
    private String loginIp;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private String loginAddr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getDeviceInfor() {
        return deviceInfor;
    }

    public void setDeviceInfor(String deviceInfor) {
        this.deviceInfor = deviceInfor;
    }

    public String getIsAvailability() {
        return isAvailability;
    }

    public void setIsAvailability(String isAvailability) {
        this.isAvailability = isAvailability;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLoginAddr() {
        return loginAddr;
    }

    public void setLoginAddr(String loginAddr) {
        this.loginAddr = loginAddr;
    }
}
