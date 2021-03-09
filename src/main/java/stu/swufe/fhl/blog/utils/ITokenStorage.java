package stu.swufe.fhl.blog.utils;


import io.jsonwebtoken.Claims;
import stu.swufe.fhl.blog.model.UserPojo;

import java.util.Map;


interface ITokenStorage {

    /**
     * tokenAd: SALT_TOKEN + tokenKey
     * @param tokenAd
     * @return
     */
    public abstract Map readRedis(String tokenAd);

    public abstract Map readMysql(String tokenAd);


    public abstract void writeRedis(String tokenAd, String tokenStr);

    public abstract void writeMysql(String tokenAd, String userId, String tokenStr);


}
