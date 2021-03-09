package stu.swufe.fhl.blog.dao;

import stu.swufe.fhl.blog.model.LooperPojo;

public interface LooperPojoMapper {
    int deleteByPrimaryKey(String id);

    int insert(LooperPojo record);

    int insertSelective(LooperPojo record);

    LooperPojo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LooperPojo record);

    int updateByPrimaryKey(LooperPojo record);
}