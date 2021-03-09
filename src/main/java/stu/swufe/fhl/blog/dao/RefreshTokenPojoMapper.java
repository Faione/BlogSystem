package stu.swufe.fhl.blog.dao;

import stu.swufe.fhl.blog.model.RefreshTokenPojo;

public interface RefreshTokenPojoMapper {
    int deleteByPrimaryKey(String id);

    int deleteByUserId(String userId);

    int insert(RefreshTokenPojo record);

    int insertSelective(RefreshTokenPojo record);

    RefreshTokenPojo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RefreshTokenPojo record);

    int updateByPrimaryKeyWithBLOBs(RefreshTokenPojo record);

    int updateByPrimaryKey(RefreshTokenPojo record);

    RefreshTokenPojo selectByTokenKey(String tokenKey);
}