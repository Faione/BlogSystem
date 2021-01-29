package stu.swufe.fhl.blog.controller.portal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu.swufe.fhl.blog.response.ResponseResult;

@RestController
@RequestMapping("/portal/web_site_info")
public class WebSiteInfoPortalApi {

    /**
     * 获得分类列表
     * @return
     */
    @GetMapping("/categroies")
    public ResponseResult listCategories(){
        return null;
    }

    /**
     * 获得文章标题
     * @return
     */
    @GetMapping("/title")
    public ResponseResult getWebSiteTitle(){
        return null;
    }

    /**
     * 获得网站统计信息
     * @return
     */
    @GetMapping("/statInfo")
    public ResponseResult getWebSiteStatInfo(){
        return null;
    }

    /**
     * 获得网站SEO
     * @return
     */
    @GetMapping("/seo")
    public ResponseResult getWebSiteSeo(){
        return null;
    }

    /**
     * 获得轮播图
     * @return
     */
    @GetMapping("/loop")
    public ResponseResult getLooper(){
        return null;
    }

    /**
     * 获得友情连接
     * @return
     */
    @GetMapping("/friendLinks")
    public ResponseResult getFriendLinks(){
        return null;
    }


}
