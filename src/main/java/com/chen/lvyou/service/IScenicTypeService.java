package com.chen.lvyou.service;

import com.chen.lvyou.entity.ScenicType;
import com.chen.lvyou.entity.Userinfo;

import java.util.List;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/5/15 17:06
 */
public interface IScenicTypeService {

    List<ScenicType> findAll(int pageNum, int pageSize);
}
