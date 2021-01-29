package stu.swufe.fhl.blog.controller.portal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu.swufe.fhl.blog.response.ResponseResult;


@RestController
@RequestMapping("/portal/search")
public class SearchPortalApi {

    /**
     * 利用关键字进行搜索
     * @param keyword
     * @return
     */
    @GetMapping("/{keyword}")
    public ResponseResult doSearch(@PathVariable("keyword") String keyword){
        return null;
    }
}
