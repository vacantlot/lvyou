package com.chen.lvyou.dao;

import java.util.List;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/5/16 10:38
 */
public interface BaseDao<T> {
    /**
     * 查询所有
     * @return
     */
    List<T> selectAll();
}
