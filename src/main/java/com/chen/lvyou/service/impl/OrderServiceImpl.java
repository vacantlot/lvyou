package com.chen.lvyou.service.impl;

import com.chen.lvyou.dao.OrderinfoDao;
import com.chen.lvyou.entity.Orderinfo;
import com.chen.lvyou.service.IOrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/5/16 11:03
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderinfoDao orderinfoDao;

    @Override
    public List<Orderinfo> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return orderinfoDao.selectAll();
    }
}
