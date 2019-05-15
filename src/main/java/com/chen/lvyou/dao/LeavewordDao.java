package com.chen.lvyou.dao;

import com.chen.lvyou.entity.LeaveWord;

public interface LeavewordDao {
    int deleteByPrimaryKey(Integer leaveWordId);

    int insert(LeaveWord record);

    int insertSelective(LeaveWord record);

    LeaveWord selectByPrimaryKey(Integer leaveWordId);

    int updateByPrimaryKeySelective(LeaveWord record);

    int updateByPrimaryKey(LeaveWord record);
}