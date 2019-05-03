package com.yxw.member.mapper;


import com.yxw.in.LoginDo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:阿倪
 * @Date: 2019/3/6 10:38
 * @Description:
 * @return:
 * @throws:
 */

public interface StudentTokenMapper {

    /**
     * 每次登录保存登录token存入token表
     *
     * @param loginDo
     * @return
     */
    public Integer insertStudentToken(LoginDo loginDo);

    /**
     * 根据用户id和登录类型,状态值0(可用),查询是否有登录信息
     *
     * @param stuId
     * @param loginType
     * @return
     */
    public LoginDo selectStudentByStuIdAndLoginType(@Param("stuId") Integer stuId, @Param("loginType") String loginType);

    /**
     * 更改登录信息中的状态值为1(不可用)
     *
     * @param token
     * @return
     */
    public Integer updateTokenAvailability(@Param("token")String token);


}
