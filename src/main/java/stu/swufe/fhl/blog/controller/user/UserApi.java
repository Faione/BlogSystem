package stu.swufe.fhl.blog.controller.user;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.swufe.fhl.blog.model.User;
import stu.swufe.fhl.blog.model.UserPojo;
import stu.swufe.fhl.blog.response.ResponseResult;
import stu.swufe.fhl.blog.services.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/user")
@Log4j
public class UserApi {

    @Autowired
    private IUserService userService;

    /**
     * 初始化管理员账户
     * @param userPojo
     * @param request
     * @return
     */
    @PostMapping("/admin_account")
    public ResponseResult initManagerAccount(@RequestBody UserPojo userPojo, HttpServletRequest request){


        return userService.initManagerAccount(userPojo, request);
    }

    /**
     * 注册账户
     * @param userPojo
     * @return
     */
    @PostMapping
    public ResponseResult register(@RequestBody UserPojo userPojo,
                                   @RequestParam("captchacode") String captchacode,
                                   @RequestParam("captchakey") String captchakey,
                                   HttpServletRequest request){

        return userService.register(userPojo, captchacode, captchakey, request);
    }

    /**
     * 用户登录
     * @param captchacode
     * @param userPojo
     * @return
     */
    @PostMapping("/{captcha}/{captchakey}")
    public ResponseResult login(@PathVariable("captcha") String captchacode, @PathVariable("captchakey") String captchakey , @RequestBody UserPojo userPojo){
        return userService.dologin(captchacode, captchakey, userPojo);
    }

    /**
     * 获得图灵验证码
     * @return
     */
    @GetMapping("/captcha")
    public void getCaptcha(HttpServletResponse response, @RequestParam("captchakey") String captchakey){

        try {
           userService.createCaptche(response, captchakey);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送邮件
     * @param email
     * @return
     */
    @GetMapping("/verify_code")
    public ResponseResult sendVerifyCode(@RequestParam("email") String email){
        log.info("email == > " + email);
        return null;
    }

    /**
     * 修改密码
     * @param userPojo
     * @return
     */
    @PutMapping("/password/{userId}")
    public ResponseResult updatePassword(@PathVariable("userId")String userId, @RequestBody UserPojo userPojo){
        return null;
    }

    /**
     * 获得用户信息
     * @param userid
     * @return
     */
    @GetMapping("/{userid}")
    public ResponseResult getUserInfo(@PathVariable("userid") String userid){
        return null;
    }

    /**
     * 更新用户信息
     * @param userPojo
     * @return
     */
    @PutMapping("/{userId}")
    public ResponseResult updateUserInfo(@PathVariable("userid") String userid, @RequestBody UserPojo userPojo){
        return null;
    }

    /**
     * 获得用户列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/userList")
    public ResponseResult listUsers(@RequestParam("page") int page, @RequestParam("size") int size){
        return null;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @DeleteMapping("/{userId}")
    public ResponseResult deleteUser(@PathVariable("userId") String userId){
        return null;
    }

}
