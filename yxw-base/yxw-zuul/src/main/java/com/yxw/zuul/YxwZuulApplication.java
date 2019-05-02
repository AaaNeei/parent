package com.yxw.zuul;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;


/**
 * 游学网zuul网关服务
 */

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableSwagger2Doc
public class YxwZuulApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(YxwZuulApplication.class, args);
    }

    /**
     * 添加文档来源
     * 管理所有swagger接口文档
     */
    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider
    {
        @Override
        public List<SwaggerResource> get()
        {
            List resources = new ArrayList<>();
            // 对应的服务的swagger注册名称
            resources.add(
                swaggerResource("yxw-api-member", "/yxw-api-member/v2/api-docs", "2.0"));
            resources.add(
                swaggerResource("yxw-api-weixin", "/yxw-api-weixin/v2/api-docs", "2.0"));

            //.....



            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location, String version)
        {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }

    }

}
