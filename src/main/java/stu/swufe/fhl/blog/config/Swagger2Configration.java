package stu.swufe.fhl.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Configration {
    public static final String VERSION = "1.0.0";


    /**
     * 前端门户
     * @return
     */
    @Bean
    public Docket portalApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(portalApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("stu.swufe.fhl.blog.controller.portal"))
                .paths(PathSelectors.any())
                .build()
                .groupName("前端门户");
    }

    private ApiInfo portalApiInfo(){
        return new ApiInfoBuilder()
                .title("博客系统门户接口文档")
                .description("前端门户接口文档")
                .version(VERSION)
                .build();
    }
    /**
     * 管理中心
     * @return
     */
    @Bean
    public Docket adminApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(adminApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("stu.swufe.fhl.blog.controller.admin"))
                .paths(PathSelectors.any())
                .build()
                .groupName("管理中心");
    }

    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder()
                .title("博客系统管理中心接口文档")
                .description("管理中心接口文档")
                .version(VERSION)
                .build();
    }

    /**
     * 用户中心
     * @return
     */
    @Bean
    public Docket usersApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(usersApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("stu.swufe.fhl.blog.controller.user"))
                .paths(PathSelectors.any())
                .build()
                .groupName("用户页面");
    }

    private ApiInfo usersApiInfo(){
        return new ApiInfoBuilder()
                .title("博客系统用户页面接口文档")
                .description("用户页面接口文档")
                .version(VERSION)
                .build();
    }
}
