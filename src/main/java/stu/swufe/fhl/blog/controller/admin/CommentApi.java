package stu.swufe.fhl.blog.controller.admin;


import org.springframework.web.bind.annotation.*;
import stu.swufe.fhl.blog.response.ResponseResult;

@RestController
@RequestMapping("admin/comment")
public class CommentApi {

    /**
     * 增加评论
     * @return
     */
    @PostMapping
    public ResponseResult addComment(){
        return null;
    }

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    @DeleteMapping("/{commentId}")
    public ResponseResult deleteComment(@PathVariable("commentId") String commentId){
        return null;
    }

    /**
     * 修改评论
     * @param commentId
     * @return
     */
    @PutMapping("/{commentId}")
    public ResponseResult updateComment(@PathVariable("commentId") String commentId){
        return null;
    }

    /**
     * 查看评论
     * @param commentId
     * @return
     */
    @GetMapping("/{commentId}")
    public ResponseResult getComment(@PathVariable("commentId") String commentId){
        return null;
    }

    /**
     * 显示评论列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listComments(@RequestParam("page") int page, @RequestParam("size") int size){
        return null;
    }
}
