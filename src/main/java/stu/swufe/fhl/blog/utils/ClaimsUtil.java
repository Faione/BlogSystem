package stu.swufe.fhl.blog.utils;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import stu.swufe.fhl.blog.model.UserPojo;

import java.util.Map;

public class ClaimsUtil {


    public static String [] userFilter = {"password", "regIp", "loginIp", "createTime", "updateTime"};


    /**
     * 类转Map
     * @param pojo
     * @return
     */

    public static Map<String, Object>  toClaims(Object pojo){
        Map<String, Object> claims = JSON.parseObject(JSON.toJSONString(pojo));
        // 过滤规则
        if( pojo instanceof UserPojo){
            for(String key : userFilter){
                claims.remove(key);
            }
        }
        return claims;
    }

    /**
     * Claims(继承Map)转对象
    * @param claims
     * @param target
     * @param <T>
     * @return
     */

    public static <T>T toPojo(Object claims, Class<T> target){

        return JSON.parseObject(JSON.toJSONString(claims)).toJavaObject(target);

    }



    public static void main(String[] args) {
        UserPojo pojo = new UserPojo();
        pojo.setUserName("fhl");
        pojo.setId("123");
        pojo.setLoginIp("123123");


        Map<String, Object> claims = ClaimsUtil.toClaims(pojo);
//        claims.remove("password");
        System.out.println(claims);
    }
}
