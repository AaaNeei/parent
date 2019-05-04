package com.yxw.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.yxw.base.BaseResponse;
import com.yxw.in.RegisterInVO;
import com.yxw.in.StudentInDTO;
import com.yxw.utils.YxwBeanUtils;
import com.yxw.web.base.BaseWebController;
import com.yxw.web.feign.MemberRegisterServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @param
 * @Author: AaNeei
 * @Date: 2019/5/4  9:28
 * @Description: 游学网
 * @throws:
 */

@Controller
@Slf4j
@RequestMapping("/member")
public class RegisterController extends BaseWebController {

    private static final String REGISTER = "register";
    private static final String LOGIN = "login";

    @Autowired
    private MemberRegisterServiceFeign memberRegisterServiceFeign;

    @GetMapping("/register")
    public String getRegister() {
        return REGISTER;

    }

    /**
     * post注册,bindingResult必须只能跟在需要校验的对象后面
     *
     * @param registerInVO
     * @param bindingResult
     * @param httpSession
     * @param model
     * @return
     */
    @PostMapping("/register")
    public String postRegister(@ModelAttribute("registerVo") @Validated RegisterInVO registerInVO,
                               BindingResult bindingResult, HttpSession httpSession, Model model) {

        // 1.参数验证
        if (bindingResult.hasErrors()) {
            // 获取第一个错误!
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            setErrorMsg(model, errorMsg);
            return REGISTER;
        }

        // 将VO转换DTO
        StudentInDTO studentInDTO = YxwBeanUtils.voToDTO(registerInVO, StudentInDTO.class);
        try {
            String registCode = registerInVO.getRegistCode();
            BaseResponse<JSONObject> register = memberRegisterServiceFeign.register(studentInDTO, registCode);
            if (!isSuccess(register)) {
                model.addAttribute("error", register.getMsg());
                return REGISTER;
            }
        } catch (Exception e) {
            log.error(">>>>>", e);
            model.addAttribute("error", "系统出现错误!");
            return REGISTER;
        }

        // 注册成功,跳转到登陆页面
        return LOGIN;
    }


}
