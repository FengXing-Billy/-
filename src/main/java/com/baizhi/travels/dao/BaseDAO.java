package com.baizhi.travels.dao;

import com.baizhi.travels.entity.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<T,K> {
    //增
    void update(T t);

    //删
    void delete(K k);

    //修改
    void modify(T t);

    //改
    void save(T t);

    //查一个
    T findOne(K k);

    //查全部
    List<T> findAll();

    //分页查
    List<T> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);


    Integer findTotals();

}
