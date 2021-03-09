package stu.swufe.fhl.blog.controller.admin;

import org.springframework.web.bind.annotation.*;
import stu.swufe.fhl.blog.model.ImagePojo;
import stu.swufe.fhl.blog.response.ResponseResult;

@RestController
@RequestMapping("admin/image")
public class ImageApi {

    /**
     * 增加图片
     * @return
     */
    @PostMapping
    public ResponseResult uploadImage(){
        return null;
    }

    /**
     * 删除图片
     * @param imageId
     * @return
     */
    @DeleteMapping("/{imageId}")
    public ResponseResult deleteImage(@PathVariable("imageId") String imageId){
        return null;
    }

    /**
     * 修改图片
     * @param imageId
     * @param imagePojo
     * @return
     */
    @PutMapping("/{imageId}")
    public ResponseResult updateImage(@PathVariable("imageId") String imageId, @RequestBody ImagePojo imagePojo){
        return null;
    }

    /**
     * 查看图片
     * @param imageId
     * @return
     */
    @GetMapping("/{imageId}")
    public ResponseResult getImage(@PathVariable("imageId") String imageId){
        return null;
    }

    /**
     * 显示图片列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listImages(@RequestParam("page") int page, @RequestParam("size") int size){
        return null;
    }
}
