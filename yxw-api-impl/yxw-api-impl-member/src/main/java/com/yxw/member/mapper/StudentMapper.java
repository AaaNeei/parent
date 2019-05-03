package com.yxw.member.mapper;


import com.yxw.in.Student;

/**
 * @Author:阿倪
 * @Date: 2019/3/6 10:38
 * @Description:
 * @return:
 * @throws:
 */

public interface StudentMapper {
    /**
     * 用户注册mapper接口
     *
     * @param student
     * @return
     */
    public Integer register(Student student);

    /**
     * 根据手机号查询用户信息
     * 校验手机号是否存在
     *
     * @param stuMobile
     * @return
     */
    public Student exitMobile(String stuMobile);

}
