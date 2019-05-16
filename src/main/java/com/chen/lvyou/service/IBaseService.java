package com.chen.lvyou.service;

import java.util.List;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/5/16 10:59
 */
public interface IBaseService<T> {
    List<T> findAll(int pageNum, int pageSize);
}
