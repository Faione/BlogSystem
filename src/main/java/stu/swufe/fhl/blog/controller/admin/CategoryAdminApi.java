package stu.swufe.fhl.blog.controller.admin;


import org.springframework.web.bind.annotation.*;
import stu.swufe.fhl.blog.model.pojo.CategoryPojo;
import stu.swufe.fhl.blog.response.ResponseResult;

/**
 * 管理中心，分类Api
 */
@RestController
@RequestMapping("/admin/category")
public class CategoryAdminApi {

    /**
     * 添加类别
     * @return
     */
    @PostMapping
    public ResponseResult addCategory(@RequestBody CategoryPojo categoryPojo){
        return null;
    }

    /**
     * 删除分类
     * @return
     */
    @DeleteMapping("/{categoryId}")
    public ResponseResult deleteCategory(@PathVariable("categoryId") String categoryId){
        return null;
    }

    /**
     * 修改类别
     * @return
     */
    @PutMapping("/{categoryId}")
    public ResponseResult addCategory(@PathVariable("categoryId")String category, @RequestBody CategoryPojo categoryPojo){
        return null;
    }

    /**
     * 获取指定类别
     * @return
     */
    @GetMapping("/{categoryId}")
    public ResponseResult getCategory(@PathVariable("categoryId")String category, @RequestBody CategoryPojo categoryPojo){
        return null;
    }

    /**
     * 获取分类列表
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listCategories(@RequestParam("page") int page, @RequestParam("size") int size){
        return null;
    }
}
