package com.baizhi.travels.service;

import com.baizhi.travels.entity.Place;
import com.baizhi.travels.entity.Team;
import com.baizhi.travels.entity.Type;
import com.baizhi.travels.entity.UserCollection;

import java.util.List;

public interface PlaceService {


    List<Place> findByProvinceIdPage(Integer page,Integer rows,String provinceId);


    Integer findByProvinceIdCounts(String provinceId);

    String findProvince(String pid);

    void save(Place place);

    void delete(String id);

    Place findOne(String id);

    void update(Place place);

    List<Type> findtypes();

    List<Place> findOneByname(String sname);

    List<Place> findrecommend(int id);

    List<Place> findrank4();

    UserCollection FindCollection(Integer id, String sname);

    void collectspot(Integer id, String sname);

    List<UserCollection> findcollect(int id);

    List<Place> findAllSpot(String id);

    Integer findSpotCounts(String id);

    List<Place> findRankFive(String pid);

    List<Team> findTeam(String id);

    void deletespot(String sid, String uid);

    Integer findRequireCounts(String pid, String lid);

    List<Place> findRequireAESC(String pid, String lid);

    List<Place> findRequireDESC(String pid, String lid);

    List<Place> findSnames(String sname);
}
