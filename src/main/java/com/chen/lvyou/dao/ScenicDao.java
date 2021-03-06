package com.chen.lvyou.dao;

import com.chen.lvyou.entity.Scenic;

import java.util.List;

public interface ScenicDao {
    int deleteByPrimaryKey(Integer scenicId);

    int insert(Scenic record);

    int insertSelective(Scenic record);

    Scenic selectByPrimaryKey(Integer scenicId);

    int updateByPrimaryKeySelective(Scenic record);

    int updateByPrimaryKey(Scenic record);

    List<Scenic> selectAll();
}