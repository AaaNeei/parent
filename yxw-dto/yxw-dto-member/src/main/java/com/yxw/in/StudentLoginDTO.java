package com.yxw.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/3  18:02
 * @Description: 游学网  用户登录dto
 * @throws:
 */
@Data
@ApiModel(value = "用户登录dto")
public class StudentLoginDTO implements Serializable {

    private static final long serialVersionUID = 468886687282257865L;

    @ApiModelProperty(value = "用户名")
    private String stuUsername;
    @ApiModelProperty(value = "登录密码")
    private String stuPassword;
    @ApiModelProperty(value = "手机号")
    private String stuMobile;
    @ApiModelProperty(value = "登录类型")
    private String loginType;
    @ApiModelProperty(value = "登录设备信息")
    private String deviceInfor;
    @ApiModelProperty(value = "登录ip")
    private String loginIp;

    public String getStuUsername() {
        return stuUsername;
    }

    public void setStuUsername(String stuUsername) {
        this.stuUsername = stuUsername;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public String getStuMobile() {
        return stuMobile;
    }

    public void setStuMobile(String stuMobile) {
        this.stuMobile = stuMobile;
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

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}
