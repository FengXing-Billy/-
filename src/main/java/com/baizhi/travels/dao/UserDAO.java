package com.baizhi.travels.dao;

import com.baizhi.travels.entity.Admin;
import com.baizhi.travels.entity.Place;
import com.baizhi.travels.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDAO extends BaseDAO<User,Integer>{

    Integer findAllUserCounts();

    //用户表
    List<User> findAllUserPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //根据用户名查询用户
    User findByUsername(String uname);

    //查询管理员
    Admin findAdmin(String name);
}
