package com.yxw.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/3  17:49
 * @Description: 游学网 登陆do对象
 * @throws:
 */
@Data
@ApiModel(value = "登录信息DTO")
public class LoginInDTO implements Serializable {

    private static final long serialVersionUID = -5560855696011164608L;
    @ApiModelProperty(value = "登录token")
    private String token;
    @ApiModelProperty(value = "登录类型")
    private String loginType;
    @ApiModelProperty(value = "登录设备信息")
    private String deviceInfor;
    @ApiModelProperty(value = "用户id")
    private String stuId;
    @ApiModelProperty(value = "登录ip")
    private String loginIp;
    @ApiModelProperty(value = "登录地址")
    private String loginAddr;


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

    public String getLoginAddr() {
        return loginAddr;
    }

    public void setLoginAddr(String loginAddr) {
        this.loginAddr = loginAddr;
    }
}
