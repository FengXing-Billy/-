package com.baizhi.travels.service;

import com.baizhi.travels.dao.StrategyDAO;
import com.baizhi.travels.entity.Team;
import com.baizhi.travels.entity.UserStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class StrategyServiceImpl implements StrategyService{

    @Resource
    private StrategyDAO strategyDao;

    @Override
    public List<Team> StrategyInfo() {
        return strategyDao.findAll();
    }

    public List<UserStrategy> getUserStrategy(int id){
       return strategyDao.getUserStrategy(id);
    }

    public void strategyAdd(Integer id,Integer tid){
            strategyDao.strategyAdd(id,tid);
    }

    public UserStrategy findUserStrategy(Integer id, Integer tid){
        return strategyDao.findUserStrategy(id,tid);
    }

    public void deleteMystrategy(String tid, String uid){
        strategyDao.deleteMystrategy(tid,uid);
    }
}
