package stu.swufe.fhl.blog.services.impl;


import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import stu.swufe.fhl.blog.dao.RefreshTokenPojoMapper;
import stu.swufe.fhl.blog.dao.UserPojoMapper;
import stu.swufe.fhl.blog.model.RefreshTokenPojo;
import stu.swufe.fhl.blog.model.UserPojo;
import stu.swufe.fhl.blog.response.ResponseMsg;
import stu.swufe.fhl.blog.response.ResponseResult;
import stu.swufe.fhl.blog.response.ResponseState;
import stu.swufe.fhl.blog.services.IUserService;
import stu.swufe.fhl.blog.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Service
@Log4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserPojoMapper userPojoMapper;

    @Autowired
    private RefreshTokenPojoMapper refreshTokenPojoMapper;

    @Autowired
    private IDWorker idWorker;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;




    @Override
    public ResponseResult initManagerAccount(UserPojo userPojo, HttpServletRequest request) {

        // 1. 检查是否初始化
        if(TextUtils.isEmpty(userPojo.getUserName())){
            return ResponseResult.creatFailed(ResponseMsg.USERNAME_EMPTY);
        }

        if(userPojoMapper.selectByName(userPojo.getUserName())>0){
            return ResponseResult.creatFailed(ResponseMsg.USER_EXIST);
        }


        // 2. 空值检测
        if(TextUtils.isEmpty(userPojo.getPassword())){
            return ResponseResult.creatFailed(ResponseMsg.PASSWORD_EMPTY);
        }
        if(TextUtils.isEmpty(userPojo.getEmail())){
            return ResponseResult.creatFailed(ResponseMsg.EMAIL_ENPTY);
        }


        // 3. 初始化默认参数
        userPojo.setId(String.valueOf(idWorker.nextId()));
        userPojo.setPassword(bCryptPasswordEncoder.encode(userPojo.getPassword()));
        userPojo.setRoles(Constants.User.ROlA_ADMIN);
        userPojo.setAvatar(Constants.User.DEFAULT_AVATAR);
        userPojo.setState(Constants.User.DEFAULT_STATE);

        setDefaultInfo(userPojo, request);

        // 4. 保存入数据库
        logUserPojo(userPojo);

        userPojoMapper.insert(userPojo);


        return ResponseResult.createSuccess();
    }


    @Override
    public void createCaptche(HttpServletResponse response, String captchakey) throws IOException {
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


        // 验证码存入Redis
        redisUtil.set(Constants.StaticValue.SALT_CAPTCHA + captchakey, specCaptcha.text(), 5*60);

        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }

    @Override
    public ResponseResult register(UserPojo userPojo, String captchacode, String captchakey, HttpServletRequest request) {
        // 1. 检查图灵验证码是否正确
        if(cheakCaptcha(captchacode, captchakey)!=null)  return cheakCaptcha(captchacode, captchakey);

        // 2. 检查用户是否注册
        String username = userPojo.getUserName();
        if(TextUtils.isEmpty(username)){
            return ResponseResult.creatFailed(ResponseMsg.USERNAME_EMPTY);
        }
        if(userPojoMapper.selectByName(username)>0){
            return ResponseResult.creatFailed(ResponseMsg.USER_EXIST);
        }


        // 3. 密码加密
        userPojo.setPassword(bCryptPasswordEncoder.encode(userPojo.getPassword()));

        // 4. 补全数据

        userPojo.setId(String.valueOf(idWorker.nextId()));
        userPojo.setRoles(Constants.User.NORMAL_USER);
        userPojo.setAvatar(Constants.User.DEFAULT_AVATAR);
        userPojo.setState(Constants.User.NORMAL_STATE);

        setDefaultInfo(userPojo, request);

        // 5. 存入数据库
        logUserPojo(userPojo);


        userPojoMapper.insert(userPojo);

        return ResponseResult.createSuccess(ResponseState.REGISTER_SUCCESS, userPojo);
    }

    @Override
    public ResponseResult dologin(String captchacode, String captchakey, UserPojo userPojo) {
        // 1. 检查图灵验证码是否正确
        if(cheakCaptcha(captchacode, captchakey)!=null)  return cheakCaptcha(captchacode, captchakey);

        // 2. 空值检测
        String username = userPojo.getUserName();
        String password = userPojo.getPassword();

        if(TextUtils.isEmpty(username)){
            return ResponseResult.creatFailed(ResponseMsg.USERNAME_EMPTY);
        }
        if(TextUtils.isEmpty(password)){
            return ResponseResult.creatFailed(ResponseMsg.PASSWORD_EMPTY);
        }


        // 2. 检查用户是否注册
        UserPojo userFromDb = userPojoMapper.selectAllByName(username);
        // 3. 验证密码是否正确
        if(userFromDb==null || !bCryptPasswordEncoder.matches(password, userFromDb.getPassword())){
            return ResponseResult.creatFailed("用户名或密码错误");
        }

        // 4. 密码正确，生成Token
        Map<String, Object> claims = ClaimsUtil.toClaims(userFromDb);

        TokenStorage tokenStorage = new TokenStorage(redisUtil, refreshTokenPojoMapper, userPojoMapper, idWorker);

        tokenStorage.reFresh(claims);

        return ResponseResult.createSuccess(ResponseState.LOGIN_SUCCESS).setToken(tokenStorage.getNewTokenkey());
    }

    @Override
    public UserPojo checkUser(StringBuffer tokenkeyBuffer) {

        TokenStorage tokenStorage = new TokenStorage(redisUtil, refreshTokenPojoMapper, userPojoMapper, idWorker);
        Map<String, Object> claims = tokenStorage.readRedis(String.valueOf(tokenkeyBuffer));


        if(claims!=null){
            if(tokenStorage.getNewTokenkey()!=null){
                tokenkeyBuffer.delete(0, tokenkeyBuffer.length());
                tokenkeyBuffer.append(tokenStorage.getNewTokenkey());
            }
            return ClaimsUtil.toPojo(claims, UserPojo.class);
        }
        return null;

    }


    private ResponseResult cheakCaptcha(String captchacode, String captchakey){
        if(TextUtils.isEmpty(captchacode)){
            return ResponseResult.creatFailed(ResponseMsg.CAPTCHA_EMPTY);
        }

        String captchaverifycode = (String) redisUtil.get(Constants.StaticValue.SALT_CAPTCHA + captchakey);

        if(TextUtils.isEmpty(captchaverifycode)){
            return ResponseResult.creatFailed("验证码过期");
        }

        if(!captchaverifycode.equals(captchacode)){
            return ResponseResult.creatFailed("验证码错误");
        }else{
            redisUtil.del(Constants.StaticValue.SALT_CAPTCHA + captchakey);
            return null;
        }
    }

    private void setDefaultInfo(UserPojo userPojo, HttpServletRequest request) {
        // 设置 ip
        userPojo.setLoginIp(request.getRemoteAddr());
        userPojo.setRegIp(request.getRemoteAddr());

        // 设置 日期
        userPojo.setCreateTime(new Date());
        userPojo.setUpdateTime(new Date());
    }

    public static void logUserPojo(UserPojo userPojo){
        log.info("UserName == >" + userPojo.getUserName());
        log.info("Password == >" + userPojo.getPassword());
        log.info("Email == >" + userPojo.getEmail());
        log.info("Avatar == >" + userPojo.getAvatar());
        log.info("State == >" + userPojo.getState());
        log.info("LoginIp == >" + userPojo.getLoginIp());
        log.info("RegIp == >" + userPojo.getRegIp());
        log.info("CreateTime == >" + userPojo.getCreateTime());
        log.info("UpdateTime == >" + userPojo.getUpdateTime());
    }

}
