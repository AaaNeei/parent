package com.yxw.web.controller;

import com.yxw.base.BaseResponse;
import com.yxw.out.StudentOutDTO;
import com.yxw.util.CookieUtils;
import com.yxw.web.base.BaseWebController;
import com.yxw.web.constants.WebConstants;
import com.yxw.web.feign.MemberServiceFeign;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/4  9:19
 * @Description: 游学网
 * @throws:
 */
@Controller
@RequestMapping("/member")
public class IndexController extends BaseWebController {
    private static final String INDEX = "index";


    private MemberServiceFeign memberServiceFeign;

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        // 1.从cookie 中 获取 会员token
        String token = CookieUtils.getCookieValue(request, WebConstants.MEMBER_LOGIN_COOKIE_NAME, true);
        if (!StringUtils.isEmpty(token)) {
            // 2.调用会员服务接口,查询会员用户信息
            BaseResponse<StudentOutDTO> userInfo = memberServiceFeign.getStudentByToken(token);
            if (isSuccess(userInfo)) {
                StudentOutDTO data = userInfo.getData();
                if (data != null) {
                    String mobile = data.getStuMobile();
                    // 对手机号码实现脱敏
                    String desensMobile = mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
                    model.addAttribute("desensMobile", desensMobile);
                }

            }

        }
        return INDEX;
    }


}
