package stu.swufe.fhl.blog.services;

import stu.swufe.fhl.blog.model.UserPojo;
import stu.swufe.fhl.blog.response.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IUserService {

    /**
     * 初始化管理员
     * @param userPojo
     * @param request
     * @return
     */
    ResponseResult initManagerAccount(UserPojo userPojo, HttpServletRequest request);


    /**
     * 获得图形验证码
     * @param response
     * @param captchakey
     * @throws IOException
     */
    void createCaptche(HttpServletResponse response, String captchakey) throws IOException;


    /**
     * 用户注册
     * @param userPojo
     * @param captchacode
     * @param captchakey
     * @param request
     * @return
     */
    ResponseResult register(UserPojo userPojo, String captchacode, String captchakey, HttpServletRequest request);


    /**
     * 用户登录
     * @param captchacode
     * @param captchakey
     * @param userPojo
     * @return
     */
    ResponseResult dologin(String captchacode, String captchakey, UserPojo userPojo);

    /**
     * 检验Token，并返回用户对象
     * @param tokenkey
     * @return
     */
    UserPojo checkUser(StringBuffer tokenkey);
}
