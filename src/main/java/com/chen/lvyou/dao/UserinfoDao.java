package com.chen.lvyou.dao;

import com.chen.lvyou.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserinfoDao {
    int deleteByPrimaryKey(String userId);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    Userinfo findByUsername(@Param("name") String name);

    /**
     * 查询所有的用户
     * @return
     */
    List<Userinfo> selectAllUser();

}