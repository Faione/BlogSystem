package stu.swufe.fhl.blog.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import stu.swufe.fhl.blog.model.pojo.User;
import stu.swufe.fhl.blog.response.ResponseResult;


@Log4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public ResponseResult helloWorld(){
        ResponseResult responseResult=ResponseResult.Success();
        log.info("Hellow World");

        return responseResult;
    }

    @GetMapping("/user")
    public ResponseResult testUser(){
        User user = new User();
        user.setUsername("fhl");
        user.setEmail("1123@abc");
        user.setRole(1);
        ResponseResult responseResult = ResponseResult.Success(user);
        return responseResult;
    }

    @PostMapping("/login")
    public ResponseResult testLogin(@RequestBody User user){

        return ResponseResult.Success(user);
    }
}
