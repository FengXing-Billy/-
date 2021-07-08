package com.baizhi.travels.dao;

import com.baizhi.travels.entity.Place;
import com.baizhi.travels.entity.UserStrategy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StrategyDAO extends BaseDAO{
    List<UserStrategy> getUserStrategy(int id);

    void strategyAdd(Integer id,Integer tid);

    UserStrategy findUserStrategy(Integer id, Integer tid);

    void deleteMystrategy(String tid, String uid);
}
