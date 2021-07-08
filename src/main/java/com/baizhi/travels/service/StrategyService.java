package com.baizhi.travels.service;

import com.baizhi.travels.entity.Team;
import com.baizhi.travels.entity.UserStrategy;

import java.util.List;

public interface StrategyService {

    void strategyAdd(Integer id, Integer tid);

    UserStrategy findUserStrategy(Integer id, Integer tid);

    List<Team> StrategyInfo();

    List<UserStrategy> getUserStrategy(int id);

    void deleteMystrategy(String tid, String uid);
}
