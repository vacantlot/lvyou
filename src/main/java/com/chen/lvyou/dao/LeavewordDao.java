package com.chen.lvyou.dao;

import com.chen.lvyou.entity.Leaveword;

public interface LeavewordDao {
    int deleteByPrimaryKey(Integer leaveWordId);

    int insert(Leaveword record);

    int insertSelective(Leaveword record);

    Leaveword selectByPrimaryKey(Integer leaveWordId);

    int updateByPrimaryKeySelective(Leaveword record);

    int updateByPrimaryKey(Leaveword record);
}