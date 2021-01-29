package stu.swufe.fhl.blog.controller.admin;


import org.springframework.web.bind.annotation.*;
import stu.swufe.fhl.blog.model.pojo.FriendPojo;
import stu.swufe.fhl.blog.response.ResponseResult;

@RestController
@RequestMapping("admin/friend_link")
public class FriendLinkApi {

    /**
     * 增加合作伙伴
     * @param friendPojo
     * @return
     */
    @PostMapping
    public ResponseResult addFriendLink(@RequestBody FriendPojo friendPojo){
        return null;
    }

    /**
     * 删除合作伙伴
     * @param friendLinkId
     * @return
     */
    @DeleteMapping("/{friendLinkId}")
    public ResponseResult deleteFriendLink(@PathVariable("friendLinkId") String friendLinkId){
        return null;
    }

    /**
     * 修改合作伙伴
     * @param friendLinkId
     * @return
     */
    @PutMapping("/{friendLinkId}")
    public ResponseResult updateFriendLink(@PathVariable("friendLinkId") String friendLinkId){
        return null;
    }

    /**
     * 查看合作伙伴
     * @param friendLinkId
     * @return
     */
    @GetMapping("/{friendLinkId}")
    public ResponseResult getFriendLink(@PathVariable("friendLinkId") String friendLinkId){
        return null;
    }

    /**
     * 显示合作伙伴列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResponseResult listFriendLinks(@RequestParam("page") int page, @RequestParam("size") int size){
        return null;
    }


}
