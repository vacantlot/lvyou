package com.chen.lvyou.service.impl;

import com.chen.lvyou.dao.ScenictypeDao;
import com.chen.lvyou.entity.ScenicType;
import com.chen.lvyou.service.IScenicTypeService;
import com.chen.lvyou.shiro.CustomRealm;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/5/15 17:10
 */
@Service
public class ScenicTypeServiceImpl implements IScenicTypeService {

    @Resource
    private ScenictypeDao       scenictypeDao;
    private final static Logger logger = LoggerFactory.getLogger(ScenicTypeServiceImpl.class);

    @Override
    public List<ScenicType> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return scenictypeDao.selectAll();
    }
}
