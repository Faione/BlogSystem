package stu.swufe.fhl.blog.dao;

import stu.swufe.fhl.blog.model.pojo.CommentPojo;
import stu.swufe.fhl.blog.model.pojo.CommentPojoWithBLOBs;

public interface CommentPojoMapper {
    int deleteByPrimaryKey(String id);

    int insert(CommentPojoWithBLOBs record);

    int insertSelective(CommentPojoWithBLOBs record);

    CommentPojoWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommentPojoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CommentPojoWithBLOBs record);

    int updateByPrimaryKey(CommentPojo record);
}