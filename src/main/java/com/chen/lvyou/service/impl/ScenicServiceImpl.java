package com.chen.lvyou.service.impl;

import com.chen.lvyou.dao.ScenicDao;
import com.chen.lvyou.entity.Scenic;
import com.chen.lvyou.service.IScenicService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ScenicServiceImpl implements IScenicService {
    @Resource
    private ScenicDao scenicDao;

    @Override public List<Scenic> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return scenicDao.selectAll();
    }
}
