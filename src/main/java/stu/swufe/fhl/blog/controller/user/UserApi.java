package stu.swufe.fhl.blog.controller.user;

import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;
import stu.swufe.fhl.blog.model.pojo.UserPojo;
import stu.swufe.fhl.blog.response.ResponseResult;

@RestController
@RequestMapping("/user")
@Log4j
public class UserApi {

    /**
     * 初始化管理员账户
     * @return
     */
    @PostMapping("/admin_account")
    public ResponseResult initManagerAccount(@RequestBody UserPojo userPojo){

        log.info("user name == > " + userPojo.getUserName());
        log.info("password == > " + userPojo.getPassword());
        log.info("email == > " + userPojo.getEmail());

        return ResponseResult.Success();
    }

    /**
     * 注册账户
     * @param userPojo
     * @return
     */
    @PostMapping
    public ResponseResult register(@RequestBody UserPojo userPojo){
        return null;
    }

    /**
     * 用户登录
     * @param captcha
     * @param userPojo
     * @return
     */
    @PostMapping("/{captcha}")
    public ResponseResult login(@PathVariable("captcha") String captcha, @RequestBody UserPojo userPojo){
        return ResponseResult.Success();
    }

    /**
     * 获得图灵验证码
     * @return
     */
    @GetMapping("/captcha")
    public ResponseResult getCaptcha(){
        return null;
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
