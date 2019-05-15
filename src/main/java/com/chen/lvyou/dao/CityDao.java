package com.chen.lvyou.dao;

import com.chen.lvyou.entity.City;

public interface CityDao {
    int deleteByPrimaryKey(String cityId);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(String cityId);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}