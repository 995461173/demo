package com.example.demo.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by lenovo on 2018/1/22.
 */

@Configuration
@ComponentScan(basePackages = {"com.example.demo.controller.*"})//配置controller路径
@EnableSwagger2
@SuppressWarnings({"unchecked","deprecation"})
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(Predicates.or(
                        //这里添加你需要展示的接口
                        PathSelectors.ant("/demo/region/**"),
                        PathSelectors.ant("/demo/feedback/**"),
                        PathSelectors.ant("/demo/user/**")
                        )
                )
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Shopping - API接口")
                .description("接口文档描述")
                .contact("ycj32t@163.com")
                .version("1.0")
                .build();
    }
}
