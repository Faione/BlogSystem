package stu.swufe.fhl.blog.controller.admin;

import org.springframework.web.bind.annotation.*;
import stu.swufe.fhl.blog.response.ResponseResult;

@RestController
@RequestMapping("admin/web_site_info")
public class WebSiteInfoApi {

    /**
     * 获得网站标题
     * @return
     */
    @GetMapping("/title")
    public ResponseResult getWebSiteTitle(){
        return null;
    }

    /**
     * 修改网站标题
     * @param title
     * @return
     */
    @PutMapping("/title")
    public ResponseResult updateWebSiteTitle(@PathVariable("title") String title){
        return null;
    }

    /**
     * 获得网站seo
     * @return
     */
    @GetMapping("/seo")
    public ResponseResult getWebSiteSeo(){
        return null;
    }

    /**
     * 修改网站seo
     * @param keywords
     * @param description
     * @return
     */
    @PutMapping("/seo")
    public ResponseResult updateWebSiteSeo(@RequestParam("keywords") String keywords, @RequestParam("description") String description){
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


}
