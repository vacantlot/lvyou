package com.chen.lvyou.service;

import com.chen.lvyou.entity.Scenic;

import java.util.List;

public interface IScenicService {
    List<Scenic> findAll(int pageNum, int pageSize);
}
