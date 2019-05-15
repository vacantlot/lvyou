package com.chen.lvyou.dao;

import com.chen.lvyou.entity.Scenictype;

public interface ScenictypeDao {
    int deleteByPrimaryKey(Integer scenicTypeId);

    int insert(Scenictype record);

    int insertSelective(Scenictype record);

    Scenictype selectByPrimaryKey(Integer scenicTypeId);

    int updateByPrimaryKeySelective(Scenictype record);

    int updateByPrimaryKey(Scenictype record);
}