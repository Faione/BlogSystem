package stu.swufe.fhl.blog.dao;

import stu.swufe.fhl.blog.model.ArticlePojo;
import stu.swufe.fhl.blog.model.ArticlePojoWithBLOBs;

public interface ArticlePojoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticlePojoWithBLOBs record);

    int insertSelective(ArticlePojoWithBLOBs record);

    ArticlePojoWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticlePojoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticlePojoWithBLOBs record);

    int updateByPrimaryKey(ArticlePojo record);
}