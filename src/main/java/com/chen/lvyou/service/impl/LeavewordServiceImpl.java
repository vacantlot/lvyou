package com.chen.lvyou.service.impl;

import com.chen.lvyou.dao.LeavewordDao;
import com.chen.lvyou.entity.LeaveWord;
import com.chen.lvyou.service.ILeavewordService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/5/16 15:34
 */
@Service
public class LeavewordServiceImpl implements ILeavewordService {
    @Resource
    private LeavewordDao leavewordDao;
    @Override public List<LeaveWord> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return leavewordDao.selectAll();
    }
}
