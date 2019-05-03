package com.yxw.error;

import com.alibaba.fastjson.JSONObject;
import com.yxw.base.BaseApiService;
import com.yxw.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:阿倪
 * @Date: 2019/5/3 16:39
 * @Description: 全局异常捕获
 * @return:
 * @throws:
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends BaseApiService<JSONObject> {
    /**
     * 运行时异常
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public BaseResponse<JSONObject> exceptionHandler(Exception e) {
        log.info("###全局捕获异常###,error:{}", e);
        return setResultError("系统错误!");
    }
}