package com.chen.lvyou.service;

import com.chen.lvyou.entity.City;

import java.util.List;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/5/15 17:39
 */
public interface ICityService {

    List<City> findAll(int pageNum, int pageSize);
}
