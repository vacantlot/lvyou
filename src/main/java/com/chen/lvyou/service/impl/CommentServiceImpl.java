package com.chen.lvyou.service.impl;

import com.chen.lvyou.dao.CommentDao;
import com.chen.lvyou.entity.Comment;
import com.chen.lvyou.service.ICommentService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/5/16 10:34
 */
@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    private CommentDao commentDao;
    @Override
    public List<Comment> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return commentDao.selectAll();
    }
}
