package com.yxw.member;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * 游学网会员工程启动类
 */

@EnableEurekaClient
@SpringBootApplication
//开启swagger接口文档
@EnableSwagger2Doc
@MapperScan(value = "com.yxw.member.mapper")
public class YxwApiImplMemberApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(YxwApiImplMemberApplication.class, args);
    }

}
