package com.chen.lvyou.service;

import com.chen.lvyou.entity.Comment;

import java.util.List;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/5/16 10:34
 */
public interface ICommentService {

    List<Comment> findAll(int pageNum, int pageSize);
}
