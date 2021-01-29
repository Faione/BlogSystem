package stu.swufe.fhl.blog.dao;

import stu.swufe.fhl.blog.model.pojo.UserPojo;

public interface UserPojoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserPojo record);

    int insertSelective(UserPojo record);

    UserPojo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);
}