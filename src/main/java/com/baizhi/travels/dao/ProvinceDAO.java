package com.baizhi.travels.dao;

import com.baizhi.travels.entity.Place;
import com.baizhi.travels.entity.Province;
import com.baizhi.travels.entity.Rank;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface ProvinceDAO extends BaseDAO<Province,String> {

    //获取排名信息
    public List<Rank> getpRank();
    public List<Place> getsRank();
}
