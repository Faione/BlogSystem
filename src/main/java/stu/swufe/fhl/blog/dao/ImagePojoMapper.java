package stu.swufe.fhl.blog.dao;

import stu.swufe.fhl.blog.model.ImagePojo;

public interface ImagePojoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ImagePojo record);

    int insertSelective(ImagePojo record);

    ImagePojo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ImagePojo record);

    int updateByPrimaryKey(ImagePojo record);
}