package stu.swufe.fhl.blog.utils;

import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j;
import org.springframework.util.DigestUtils;
import stu.swufe.fhl.blog.dao.RefreshTokenPojoMapper;
import stu.swufe.fhl.blog.dao.UserPojoMapper;
import stu.swufe.fhl.blog.model.RefreshTokenPojo;
import stu.swufe.fhl.blog.model.UserPojo;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Log4j
public class  TokenStorage implements ITokenStorage{

    public static final String classname = "TokenStorage";
    private RedisUtil redisUtil;
    private RefreshTokenPojoMapper mysqlUtil;
    private UserPojoMapper userMysqlUtil;
    private IDWorker idWorker;
    public String newTokenkey = null;
    private String userIDKey = "id";

    /**
     * 初始化
     * @param redisUtil
     * @param mysqlUtil
     * @param userMysqlUtil
     * @param idWorker
     */
    public TokenStorage(RedisUtil redisUtil, RefreshTokenPojoMapper mysqlUtil, UserPojoMapper userMysqlUtil, IDWorker idWorker){
        this.redisUtil = redisUtil;
        this.mysqlUtil = mysqlUtil;
        this.userMysqlUtil = userMysqlUtil;
        this.idWorker = idWorker;
    }


    @Override
    public Map<String, Object> readRedis(String ad) {
        String tokenStr;
        String tokenAd = Constants.StaticValue.SALT_TOKEN + ad;

        tokenStr = (String) this.redisUtil.get(tokenAd);
        // redis中，数据不空
        if(tokenStr!=null){
            // 解析token数据
            Claims claims = JwtUtil.parseJWT(tokenStr);
            if(claims!=null){
                // token数据未过期
                return claims;
            }
        }

        log.info(classname + ": token->" + tokenAd + "->已经失效");
        // redis中数据已经失效
        if(tokenStr!=null){ // 若有无效数据，则删除
            this.redisUtil.del(tokenAd);
        }

        log.info(classname + ": 请求mysql");
        // 读取mysql
        return readMysql(tokenAd);
    }

    @Override
    public Map<String, Object> readMysql(String tokenAd) {
        RefreshTokenPojo refreshTokenPojo =  this.mysqlUtil.selectByTokenKey(tokenAd);

        if(refreshTokenPojo!=null){
            Claims claims = JwtUtil.parseJWT(refreshTokenPojo.getRefreshToken());
            if(claims!=null){
                if(!refreshTokenPojo.getDirt()){ // 数据库中有数据，重置Redis
                    writeRedis(this.newTokenkey, refreshTokenPojo.getRefreshToken());
                    return claims;
                }
                log.info(classname + ": mysql数据库中数据为脏，请求原数据");
                // 数据为脏
                this.userMysqlUtil.deleteByPrimaryKey(refreshTokenPojo.getId());

                UserPojo userFromDb = this.userMysqlUtil.selectByPrimaryKey(refreshTokenPojo.getUserId());

                Map<String, Object> newClaims = ClaimsUtil.toClaims(userFromDb);

                // 重置Mysql、Redis
                log.info(classname + ": 重置Redis、Mysql中的用户token");
                reFresh(newClaims);

                return newClaims;

            }
        }

        log.info(classname + ": mysql没有数据或数据已经过期");
        // 用户未登录
        return null;
    }

    public void reFresh(Map<String, Object> newClaims){
        String userId = (String) newClaims.get(this.userIDKey);

        String tokenStr = JwtUtil.createToken(newClaims);
        String refreshToken = JwtUtil.createToken(newClaims, Constants.StaticValue.MYSQL_TOKEN_TIME);

        // Token的MD5值作为TokenKey
        this.setNewTokenkey(DigestUtils.md5DigestAsHex(tokenStr.getBytes(StandardCharsets.UTF_8)));


        new Thread(()->{
            // 重置Redis
            writeRedis(this.newTokenkey, refreshToken);

            // 重置Mysql
            this.mysqlUtil.deleteByUserId(userId);
            writeMysql(this.newTokenkey, userId, tokenStr);
        }).start();

    }

    @Override
    public void writeRedis(String ad, String tokenStr) {
        this.redisUtil.set(Constants.StaticValue.SALT_TOKEN + ad, tokenStr, Constants.RedisSetting.TOKEN_TIME);

    }

    @Override
    public void writeMysql(String ad, String userId, String tokenStr) {
        RefreshTokenPojo refreshTokenPojo = new RefreshTokenPojo();
        refreshTokenPojo.setId(String.valueOf(this.idWorker.nextId()));
        refreshTokenPojo.setDirt(false);
        refreshTokenPojo.setTokenKey(Constants.StaticValue.SALT_TOKEN + ad);
        refreshTokenPojo.setRefreshToken(tokenStr);
        refreshTokenPojo.setUserId(userId);
        refreshTokenPojo.setCreateDate(new Date());
        refreshTokenPojo.setUpdateDate(new Date());
        this.mysqlUtil.insert(refreshTokenPojo);

    }

    public String getNewTokenkey() {
        return newTokenkey;
    }

    public void setNewTokenkey(String newTokenkey) {
        this.newTokenkey = newTokenkey;
    }

}
