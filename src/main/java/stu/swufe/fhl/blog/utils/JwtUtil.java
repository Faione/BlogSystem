package stu.swufe.fhl.blog.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import stu.swufe.fhl.blog.model.UserPojo;

import javax.crypto.SecretKey;
import java.util.*;

public class JwtUtil {



    private static long ttl = 2 * Constants.TimeValue.HOUR;//2个小时


    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }


    /**
     * 创建token（给定时间）
     * @param claims
     * @param ttl
     * @return
     */
    public static String createToken(Map<String, Object> claims, long ttl) {
        JwtUtil.ttl = ttl;
        return createToken(claims);
    }

    /**
     * 创建Token（默认时间）
     * @param claims
     * @return
     */
    public static String createToken(Map<String, Object> claims) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        SecretKey key = new JwtUtil().getSecretKey();


        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .signWith(key, SignatureAlgorithm.HS256);

        if (claims != null) {
            builder.setClaims(claims);
        }

        if (ttl > 0) {
            builder.setExpiration(new Date(nowMillis + ttl));
        }
        return builder.compact();
    }

    /**
     * 创建refreshToken
     * @param userId
     * @param ttl
     * @return
     */
    public static String createRefreshToken(String userId, long ttl) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey key = new JwtUtil().getSecretKey();

        JwtBuilder builder = Jwts.builder()
                .setId(userId)
                .setIssuedAt(now)
                .signWith(key, SignatureAlgorithm.HS256);

        if (ttl > 0) {
            builder.setExpiration(new Date(nowMillis + ttl));
        }
        return builder.compact();
    }



    /**
     * 解析token
     * @param jwtStr
     * @return Claims
     */

    public static Claims parseJWT(String jwtStr) {
        SecretKey key = new JwtUtil().getSecretKey();

        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtStr).getBody();
        }catch (Exception e){
            // 解析出错，则返回空值
            return null;
        }
    }

    private SecretKey getSecretKey() {
        byte[] encodeKey = Base64Util.decode(Constants.StaticValue.TOKEN_KEY.getBytes());
        return Keys.hmacShaKeyFor(encodeKey);
    }


    public static void main(String[] args) {


        UserPojo userPojo = new UserPojo();
        userPojo.setUserName("fhl");
        userPojo.setPassword("12345");


        String jwt = JwtUtil.createToken(ClaimsUtil.toClaims(userPojo), 60* 1000);
        System.out.println(jwt);

        try {
            Claims claims1 = JwtUtil.parseJWT(jwt);

            UserPojo userPojo2  = ClaimsUtil.toPojo(claims1, UserPojo.class);
            System.out.println(userPojo.getUserName());





        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
