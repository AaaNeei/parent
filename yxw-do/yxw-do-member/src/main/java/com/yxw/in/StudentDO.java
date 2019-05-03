package com.yxw.in;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:阿倪
 * @Date: 2019/3/6 9:39
 * @Description: 学生用户数据库层实体类do对象
 * @return:
 * @throws:
 */

public class StudentDO implements Serializable {
    private static final long serialVersionUID = -1810858983160635755L;

    private Integer stuId;

    private String stuName;

    private String stuSex;

    private Integer stuAge;

    private Integer stuNum;

    private String stuAddr;

    private String stuHobbies;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

    private Date updateTime;

    private String stuUsername;

    private String stuPassword;

    private String comment;

    private Integer schoolId;

    private Integer stuCredits;

    private String stuMobile;

    private String stuEmil;

    private String stuStatus;

    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

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
