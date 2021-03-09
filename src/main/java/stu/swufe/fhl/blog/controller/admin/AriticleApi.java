package stu.swufe.fhl.blog.controller.admin;


import org.springframework.web.bind.annotation.*;
import stu.swufe.fhl.blog.response.ResponseResult;

@RestController
@RequestMapping("admin/article")
public class AriticleApi {

    /**
     * 增加文章
     * @return
     */
    @PostMapping
    public ResponseResult uploadArticle(){
        return null;
    }

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    @DeleteMapping("/{articleId}")
    public ResponseResult deleteArticle(@PathVariable("articleId") String articleId){
        return null;
    }

    /**
     * 修改文章
     * @param articleId
     * @return
     */
    @PutMapping("/{articleId}")
    public ResponseResult updateArticle(@PathVariable("articleId") String articleId){
        return null;
    }

    /**
     * 查看文章
     * @param articleId
     * @return
     */
    @GetMapping("/{articleId}")
    public ResponseResult getArticle(@PathVariable("articleId") String articleId){
        return null;
    }

    /**
     * 显示文章列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listArticles(@RequestParam("page") int page, @RequestParam("size") int size){
        return null;
    }

}
