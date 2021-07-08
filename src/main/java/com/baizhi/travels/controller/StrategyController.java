package com.baizhi.travels.controller;
import com.baizhi.travels.entity.Result;
import com.baizhi.travels.entity.Team;
import com.baizhi.travels.entity.UserStrategy;
import com.baizhi.travels.service.StrategyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("strategy")
@CrossOrigin(allowCredentials = "true") //允许跨域
@Slf4j
public class StrategyController {
    @Resource
    StrategyService strategyservice;

    @GetMapping("strinfo")
    public List<Team> getStrategyInfo(){
        List<Team> strategy=strategyservice.StrategyInfo();
        return strategy;
    }

    @GetMapping("stracollect")
    public List<UserStrategy> getUserStrategy(int id){
        List<UserStrategy> userstrategy=strategyservice.getUserStrategy(id);
        return userstrategy;
    }

    @PostMapping("addstrategy")
    public Result collectSpot(Integer id, Integer tid){
        Result result = new Result();
        if(strategyservice.findUserStrategy(id,tid)==null){
            strategyservice.strategyAdd(id,tid);
            result.setMsg("攻略收藏成功!");
        }else{
            result.setMsg("该攻略已经收藏过了!");
        }
        return result;
    }

    @GetMapping("deleteMystrategy")
    public void deleteMystrategy(String tid,String uid){
        strategyservice.deleteMystrategy(tid,uid);
    }
}
