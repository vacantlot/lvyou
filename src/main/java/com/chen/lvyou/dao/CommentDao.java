package com.chen.lvyou.dao;

import com.chen.lvyou.entity.Comment;

public interface CommentDao extends BaseDao<Comment>{
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

}