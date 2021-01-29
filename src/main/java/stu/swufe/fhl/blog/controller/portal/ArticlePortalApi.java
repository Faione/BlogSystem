package stu.swufe.fhl.blog.controller.portal;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu.swufe.fhl.blog.response.ResponseResult;

@RestController
@RequestMapping("/portal/article")
public class ArticlePortalApi {

    /**
     * 获得文章列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list/{page}/{size}")
    public ResponseResult listArticle(@PathVariable("page") int page, @PathVariable("size") int size){
        return null;
    }

    /**
     * 按分类获得文章列表
     * @param categoryId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list/{categoryId}/{page}/{size}")
    public ResponseResult listArticleByCategory(@PathVariable("categoryId") String categoryId,
                                                @PathVariable("page") int page,
                                                @PathVariable("size") int size){
        return null;
    }

    /**
     * 获得文章详情
     * @param articleId
     * @return
     */
    @GetMapping("/{articleId}")
    public ResponseResult getArticleDetail(@PathVariable("articleId") String articleId){
        return null;
    }

    /**
     * 根据当前文章获得其文章推荐
     * @param aritcleId
     * @return
     */
    @GetMapping("/recommand/{aritcleId}")
    public ResponseResult getRecommandArticle(@PathVariable("ariticleId") String aritcleId){
        return null;
    }


}
