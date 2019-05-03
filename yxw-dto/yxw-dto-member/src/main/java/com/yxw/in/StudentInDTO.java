package com.yxw.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author:阿倪
 * @Date: 2019/3/6 9:39
 * @Description:
 * @return:
 * @throws:
 */
@Data
@ApiModel(value = "用户中注册")
public class StudentInDTO implements Serializable {
    private static final long serialVersionUID = -18108589831606357L;

    @ApiModelProperty(value = "用户姓名")
    private String stuName;
    @ApiModelProperty(value = "用户性别")
    private String stuSex;
    @ApiModelProperty(value = "用户年龄")
    private Integer stuAge;
    @ApiModelProperty(value = "用户学号")
    private Integer stuNum;
    @ApiModelProperty(value = "用户地址")
    private String stuAddr;
    @ApiModelProperty(value = "用户爱好")
    private String stuHobbies;
    @ApiModelProperty(value = "用户名")
    private String stuUsername;
    @ApiModelProperty(value = "注册密码")
    private String stuPassword;
    @ApiModelProperty(value = "备注")
    private String comment;
    @ApiModelProperty(value = "所属学校id")
    private Integer schoolId;
    @ApiModelProperty(value = "学校简述")
    private Integer stuCredits;
    @ApiModelProperty(value = "手机号")
    private String stuMobile;
    @ApiModelProperty(value = "邮箱")
    private String stuEmil;


    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public Integer getStuNum() {
        return stuNum;
    }

    public void setStuNum(Integer stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuAddr() {
        return stuAddr;
    }

    public void setStuAddr(String stuAddr) {
        this.stuAddr = stuAddr;
    }

    public String getStuHobbies() {
        return stuHobbies;
    }

    public void setStuHobbies(String stuHobbies) {
        this.stuHobbies = stuHobbies;
    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getStuCredits() {
        return stuCredits;
    }

    public void setStuCredits(Integer stuCredits) {
        this.stuCredits = stuCredits;
    }

    public String getStuMobile() {
        return stuMobile;
    }

    public void setStuMobile(String stuMobile) {
        this.stuMobile = stuMobile;
    }

    public String getStuEmil() {
        return stuEmil;
    }

    public void setStuEmil(String stuEmil) {
        this.stuEmil = stuEmil;
    }
}
