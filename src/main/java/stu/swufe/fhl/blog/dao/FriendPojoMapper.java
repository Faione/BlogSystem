package stu.swufe.fhl.blog.dao;

import stu.swufe.fhl.blog.model.pojo.FriendPojo;

public interface FriendPojoMapper {
    int deleteByPrimaryKey(String id);

    int insert(FriendPojo record);

    int insertSelective(FriendPojo record);

    FriendPojo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FriendPojo record);

    int updateByPrimaryKey(FriendPojo record);
}