package stu.swufe.fhl.blog;

import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Log4j
@SpringBootApplication
@EnableSwagger2
@MapperScan("stu.swufe.fhl.blog.dao")
public class BlogApplication {
    public static void main(String[] args){
        SpringApplication.run(BlogApplication.class, args);

    }
}
