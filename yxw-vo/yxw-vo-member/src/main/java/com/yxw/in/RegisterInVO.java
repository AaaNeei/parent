package com.yxw.in;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/4  9:49
 * @Description: 游学网 注册入参vo对象
 * @throws:
 */
@Data
@Valid
public class RegisterInVO implements Serializable {


    private static final long serialVersionUID = 1602200941876833425L;

    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码不能为空")
    @Size(min = 11, max = 11, message = "手机号码长度不正确")
    @Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "手机号格式错误")
    private String stuMobile;
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空!")
    private String stuPassword;

    /**
     * 注册码
     */
    @NotNull(message = "注册码不能为空!")
    private String registCode;
    /**
     * 图形验证码
     */
    @NotBlank(message = "图形验证码不能为空!")
    private String graphicCode;


    public String getStuMobile() {
        return stuMobile;
    }

    public void setStuMobile(String stuMobile) {
        this.stuMobile = stuMobile;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public String getGraphicCode() {
        return graphicCode;
    }

    public void setGraphicCode(String graphicCode) {
        this.graphicCode = graphicCode;
    }
}
