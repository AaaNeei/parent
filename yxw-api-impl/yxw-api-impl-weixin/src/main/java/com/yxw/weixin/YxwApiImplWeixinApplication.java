package com.yxw.weixin;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * 微信服务启动类
 */
@EnableEurekaClient
@SpringBootApplication
//开启swagger接口文档
@EnableSwagger2Doc
public class YxwApiImplWeixinApplication {

    public static void main(String[] args) {
        SpringApplication.run(YxwApiImplWeixinApplication.class, args);
    }

}
