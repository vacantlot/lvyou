package com.chen.lvyou.dao;

import com.chen.lvyou.entity.ScenicType;

import java.util.List;

public interface ScenictypeDao {
    int deleteByPrimaryKey(Integer scenicTypeId);

    int insert(ScenicType record);

    int insertSelective(ScenicType record);

    ScenicType selectByPrimaryKey(Integer scenicTypeId);

    int updateByPrimaryKeySelective(ScenicType record);

    int updateByPrimaryKey(ScenicType record);

    /**
     * 查询所有的景点分类
     * @return
     */
    List<ScenicType> selectAll();
}