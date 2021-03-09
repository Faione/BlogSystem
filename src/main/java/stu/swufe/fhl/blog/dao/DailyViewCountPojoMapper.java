package stu.swufe.fhl.blog.dao;

import stu.swufe.fhl.blog.model.DailyViewCountPojo;

public interface DailyViewCountPojoMapper {
    int deleteByPrimaryKey(String id);

    int insert(DailyViewCountPojo record);

    int insertSelective(DailyViewCountPojo record);

    DailyViewCountPojo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DailyViewCountPojo record);

    int updateByPrimaryKey(DailyViewCountPojo record);
}