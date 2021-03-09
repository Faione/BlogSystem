package stu.swufe.fhl.blog.utils;


public interface Constants {
    interface User{
        String ROlA_ADMIN = "role_admin";
        String NORMAL_USER = "role_user";
        String DEFAULT_AVATAR = "https://www.bilibili.com/favicon.ico";
        String DEFAULT_STATE = "1";
        String NORMAL_STATE = "0";

    }

    interface StaticValue{
        String SALT_CAPTCHA = "captchaKey";
        String SALT_TOKEN = "tokenKey";
        long MYSQL_TOKEN_TIME = 2*TimeValue.MONTH;

        String TOKEN_KEY = "Wm1GdVoyaGhiMnhsYVdaaGJtZG9ZVzlzWldsbVlXNW5hR0Z2YkdWcGUyWm9iSDA9";
    }

    interface RedisSetting{
        long TOKEN_TIME = (long) 2 * TimeValue.HOUR;

    }


    /**
     * Second
     */
    interface TimeValue{
        int SECOND = 1000;
        int MIN = 60 * SECOND;
        int HOUR = 60 * MIN;
        int DAY = 24 * HOUR;
        int MONTH = 30 * DAY;
        int YEAR = 365 * DAY;
        int HALF_YEAR = YEAR/2;

    }

}
