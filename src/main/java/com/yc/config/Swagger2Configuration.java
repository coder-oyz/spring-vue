package com.yc.config;

import com.yc.vo.JsonModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: Swagger2Configuration
 * @Author: coder-oyz
 * @Date: 2021/4/26 18:47
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    @Value("${swagger.enable}")
    private boolean swaggerEnable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //生成文档时排除属性注解
                .ignoredParameterTypes(JsonModel.class, HttpSession.class, HttpServletRequest.class)
                .enable(swaggerEnable) //强制控制是否强制打开swagger
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yc.controller"))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("订餐系统操作接口") //设置文档的标题
                .description("订餐系统操作API接口文档") // 设置文档的描述
                .version("1.0") // 设置文档的版本信息-> 1.0.0 Version information
                .termsOfServiceUrl("http://www.baidu.com") // 设置文档的License信息->1.3 License information
                .build();
    }
}
