package stu.swufe.fhl.blog.dao;

import stu.swufe.fhl.blog.model.pojo.CategoryPojo;

public interface CategoryPojoMapper {
    int deleteByPrimaryKey(String id);

    int insert(CategoryPojo record);

    int insertSelective(CategoryPojo record);

    CategoryPojo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CategoryPojo record);

    int updateByPrimaryKeyWithBLOBs(CategoryPojo record);

    int updateByPrimaryKey(CategoryPojo record);
}