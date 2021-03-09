package stu.swufe.fhl.blog.dao;

import stu.swufe.fhl.blog.model.SettingPojo;

public interface SettingPojoMapper {
    int deleteByPrimaryKey(String id);

    int insert(SettingPojo record);

    int insertSelective(SettingPojo record);

    SettingPojo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SettingPojo record);

    int updateByPrimaryKey(SettingPojo record);
}