package stu.swufe.fhl.blog;

import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import stu.swufe.fhl.blog.utils.IDWorker;
import stu.swufe.fhl.blog.utils.RedisUtil;

@Log4j
@SpringBootApplication
@EnableSwagger2
@MapperScan("stu.swufe.fhl.blog.dao")
public class BlogApplication {
    public static void main(String[] args){
        SpringApplication.run(BlogApplication.class, args);

    }

    @Bean
    public IDWorker createIDWorker(){
        return new IDWorker(0, 0, 1000);
    }

    @Bean
    public RedisUtil createRedisUtil(){
        return new RedisUtil();
    }

    @Bean
    public BCryptPasswordEncoder createBCryptPasswordEncoder(){return new BCryptPasswordEncoder();}

}
