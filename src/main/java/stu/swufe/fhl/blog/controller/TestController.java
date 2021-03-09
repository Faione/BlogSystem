package stu.swufe.fhl.blog.controller;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import stu.swufe.fhl.blog.model.User;
import stu.swufe.fhl.blog.model.UserPojo;
import stu.swufe.fhl.blog.response.ResponseResult;
import stu.swufe.fhl.blog.services.IUserService;
import stu.swufe.fhl.blog.services.impl.UserServiceImpl;
import stu.swufe.fhl.blog.utils.RedisUtil;
import stu.swufe.fhl.blog.utils.TextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.UUID;


@Log4j
@RestController
@RequestMapping("/test")
public class TestController {
    private static final String NAME = "TestController";

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    IUserService iUserService;

    @GetMapping("/hello")
    public ResponseResult helloWorld(){
        ResponseResult responseResult=ResponseResult.createSuccess();
        log.info("Hellow World");

        return responseResult;
    }

    @GetMapping("/user")
    public ResponseResult testUser(){
        User user = new User();
        user.setUsername("fhl");
        user.setEmail("1123@abc");
        user.setRole(1);
        ResponseResult responseResult = ResponseResult.createSuccess();
        return responseResult;
    }

    @PostMapping("/login")
    public ResponseResult testLogin(@RequestBody User user){

        return ResponseResult.createSuccess();
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletResponse response, @RequestParam("captcha_key") String captchakey) throws Exception {
        if(TextUtils.isEmpty(captchakey) || captchakey.length() < 13){
            return;
        }

        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 设置字体
        specCaptcha.setFont(new Font("Verdana", Captcha.FONT_1, 32));  // 有默认字体，可以不用设置
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_DEFAULT);

        // 验证码存入session
        new Thread(()->{
            redisUtil.set("testkey", specCaptcha.text(), 5*60);
        }).start();

//        request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());

        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }

    @PostMapping("/comment")
    public ResponseResult testComment(@RequestParam("tokenKey") String tokenKey, HttpServletRequest request, HttpServletResponse response){

        StringBuffer stringBuffer = new StringBuffer(tokenKey);

        log.info(NAME+": oriToken-> " +  String.valueOf(stringBuffer));

        UserPojo userPojo = null;
        if((userPojo=iUserService.checkUser(stringBuffer))==null){
         return  ResponseResult.creatFailed("登录过期，请登录");
        }else{
            log.info(NAME+": newToken-> " +  String.valueOf(stringBuffer));

            UserServiceImpl.logUserPojo(userPojo);
            return ResponseResult.createSuccess("评论成功").setToken(String.valueOf(stringBuffer));
        }


    }

}
