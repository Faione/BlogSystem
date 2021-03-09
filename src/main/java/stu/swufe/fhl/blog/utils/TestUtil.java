package stu.swufe.fhl.blog.utils;

import com.alibaba.fastjson.JSON;
import springfox.documentation.spring.web.json.Json;
import stu.swufe.fhl.blog.model.User;
import stu.swufe.fhl.blog.model.UserPojo;

import java.util.Map;

public class TestUtil {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("fhl");
        user.setEmail("1123@abc");
        user.setRole(1);
        Map<String, Object> map = JSON.parseObject(JSON.toJSONString(user), Map.class);

        System.out.println(map.get("username"));
    }
}
