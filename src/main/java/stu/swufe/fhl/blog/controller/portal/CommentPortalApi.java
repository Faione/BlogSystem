package stu.swufe.fhl.blog.controller.portal;

import org.springframework.web.bind.annotation.*;
import stu.swufe.fhl.blog.model.pojo.CommentPojo;
import stu.swufe.fhl.blog.model.pojo.LooperPojo;
import stu.swufe.fhl.blog.response.ResponseResult;


@RestController
@RequestMapping("/portal/comment")
public class CommentPortalApi {
    /**
     * 增加轮播图
     * @param commentPojo
     * @return
     */
    @PostMapping
    public ResponseResult addComment (@RequestBody CommentPojo commentPojo){
        return null;
    }

    /**
     * 删除轮播图
     * @param commentId
     * @return
     */
    @DeleteMapping("/{commentId}")
    public ResponseResult deleteComment(@PathVariable("commentId") String commentId){
        return null;
    }

    /**
     * 修改轮播图
     * @param commentId
     * @return
     */
    @PutMapping("/{commentId}")
    public ResponseResult updateComment(@PathVariable("commentId") String commentId){
        return null;
    }

    /**
     * 显示轮播图列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listComments(@RequestParam("page") int page, @RequestParam("size") int size){
        return null;
    }

}
