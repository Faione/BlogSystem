package stu.swufe.fhl.blog.dao;

import stu.swufe.fhl.blog.model.pojo.LabelPojo;

public interface LabelPojoMapper {
    int deleteByPrimaryKey(String id);

    int insert(LabelPojo record);

    int insertSelective(LabelPojo record);

    LabelPojo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LabelPojo record);

    int updateByPrimaryKey(LabelPojo record);
}