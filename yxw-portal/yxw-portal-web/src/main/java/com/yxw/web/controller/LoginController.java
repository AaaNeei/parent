package com.yxw.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.yxw.base.BaseResponse;
import com.yxw.in.LoginInVO;
import com.yxw.in.StudentLoginDTO;
import com.yxw.util.CookieUtils;
import com.yxw.util.RandomValidateCodeUtil;
import com.yxw.utils.YxwBeanUtils;
import com.yxw.web.base.BaseWebController;
import com.yxw.web.constants.WebConstants;
import com.yxw.web.feign.MemberLoginServiceFeign;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.UserAgent;
import nl.bitwalker.useragentutils.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/4  9:21
 * @Description: 游学网
 * @throws:
 */
@Controller
@RequestMapping("/member")
public class LoginController extends BaseWebController {
    private static final String LOGIN = "login";
    private static final String INDEX = "index";

    @Autowired
    private MemberLoginServiceFeign memberLoginServiceFeign;

    @GetMapping("/login")
    public String getLogin() {
        return LOGIN;

    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("loginVo") LoginInVO loginInVO, Model model, HttpServletRequest request,
                            HttpServletResponse response, HttpSession httpSession) {

        // 1.图形验证码判断
        String graphicCode = loginInVO.getGraphicCode();
        if (!RandomValidateCodeUtil.checkVerify(graphicCode, httpSession)) {
            setErrorMsg(model, "图形验证码不正确!");
            return LOGIN;
        }

        // 2.将vo转换为dto
        StudentLoginDTO studentLoginDTO = YxwBeanUtils.voToDTO(loginInVO, StudentLoginDTO.class);
        //登录类型 写死??
        studentLoginDTO.setLoginType(WebConstants.MEMBER_LOGIN_TYPE_PC);
        //获取登录来源
        String info = webBrowserInfo(request);
        studentLoginDTO.setDeviceInfor(info);
        BaseResponse<JSONObject> login = memberLoginServiceFeign.login(studentLoginDTO);
        if (!isSuccess(login)) {
            setErrorMsg(model, login.getMsg());
            return LOGIN;
        }
        // 2.将token存入到cookie中
        JSONObject data = login.getData();
        String token = data.getString("token");
        CookieUtils.setCookie(request, response, WebConstants.MEMBER_LOGIN_COOKIE_NAME, token);
        // 登陆成功后，跳转到首页
        return INDEX;
    }

    /**
     * 退出
     *
     * @param request
     * @return
     */
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request, HttpServletResponse response) {
        // 1. 从cookie中获取token
        String token = CookieUtils.getCookieValue(request, WebConstants.MEMBER_LOGIN_COOKIE_NAME);
        if (!StringUtils.isEmpty(token)) {
            BaseResponse<JSONObject> delToken = memberLoginServiceFeign.exit(token);
            if (isSuccess(delToken)) {
                //成功之后 删除cookie信息
                CookieUtils.deleteCookie(request, response, WebConstants.MEMBER_LOGIN_COOKIE_NAME);
                return INDEX;
            }

        }

        return ERROR_500_FTL;
    }

    /**
     * 获取浏览器信息
     *
     * @return
     */
    private String webBrowserInfo(HttpServletRequest request) {
        // 获取浏览器信息
        Browser browser = UserAgent.parseUserAgentString(request.getHeader("User-Agent")).getBrowser();
        // 获取浏览器版本号
        Version version = browser.getVersion(request.getHeader("User-Agent"));
        String info = browser.getName() + "/" + version.getVersion();
        return info;
    }

}
