package com.chen.lvyou.service.impl;

import com.chen.lvyou.dao.CityDao;
import com.chen.lvyou.entity.City;
import com.chen.lvyou.service.ICityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/5/15 17:40
 */
@Service
public class CityServiceImpl implements ICityService {

    @Resource
    private CityDao cityDao;

    @Override public List<City> findAll(int pageNum, int pageSize) {
        return cityDao.selectAll(pageNum,pageSize);
    }
}
