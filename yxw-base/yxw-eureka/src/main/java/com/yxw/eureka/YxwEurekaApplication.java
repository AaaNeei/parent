package com.yxw.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author: niping
 * @contact: 游学网
 * @date: ${DATE} ${TIME}
 * @version V1.0
 * @Copyright
 * @description: 游学网eureka注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class YxwEurekaApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(YxwEurekaApplication.class, args);
    }

}
