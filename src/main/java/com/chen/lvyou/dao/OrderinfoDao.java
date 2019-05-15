package com.chen.lvyou.dao;

import com.chen.lvyou.entity.Orderinfo;

public interface OrderinfoDao {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orderinfo record);

    int insertSelective(Orderinfo record);

    Orderinfo selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Orderinfo record);

    int updateByPrimaryKey(Orderinfo record);
}