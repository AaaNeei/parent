package com.yxw.member.constant;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/3  19:03
 * @Description: 游学网
 * @throws:
 */
public interface MemberConstants {


    String MEMBER_LOGIN_TYPE_ANDROID = "android";
    String MEMBER_LOGIN_TYPE_IOS = "ios";
    String MEMBER_LOGIN_TYPE_PC = "pc";
    /**
     * 会员登录redis中token前缀
     */
    String MEMBER_TOKEN_KEY_PREFIX = "member_login_token";
    /**
     * 超时时间90天
     */
    Long MEMBRE_LOGIN_TOKEN_TIMEOUT = 60 * 60 * 24 * 90L;

}
