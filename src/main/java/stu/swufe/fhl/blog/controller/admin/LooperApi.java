package stu.swufe.fhl.blog.controller.admin;

import org.springframework.web.bind.annotation.*;
import stu.swufe.fhl.blog.model.pojo.LooperPojo;
import stu.swufe.fhl.blog.response.ResponseResult;

@RestController
@RequestMapping("admin/looper")
public class LooperApi {

    /**
     * 增加轮播图
     * @param looperPojo
     * @return
     */
    @PostMapping
    public ResponseResult addLooper(@RequestBody LooperPojo looperPojo){
        return null;
    }

    /**
     * 删除轮播图
     * @param loopId
     * @return
     */
    @DeleteMapping("/{loopId}")
    public ResponseResult deleteLooper(@PathVariable("loopId") String loopId){
        return null;
    }

    /**
     * 修改轮播图
     * @param loopId
     * @return
     */
    @PutMapping("/{loopId}")
    public ResponseResult updateLooper(@PathVariable("loopId") String loopId){
        return null;
    }

    /**
     * 查看轮播图
     * @param loopId
     * @return
     */
    @GetMapping("/{loopId}")
    public ResponseResult getLooper(@PathVariable("loopId") String loopId){
        return null;
    }

    /**
     * 显示轮播图列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listLoopers(@RequestParam("page") int page, @RequestParam("size") int size){
        return null;
    }
}
