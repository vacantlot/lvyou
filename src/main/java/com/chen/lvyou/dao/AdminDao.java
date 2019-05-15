package com.chen.lvyou.dao;

import com.chen.lvyou.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    int deleteByPrimaryKey(String username);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}