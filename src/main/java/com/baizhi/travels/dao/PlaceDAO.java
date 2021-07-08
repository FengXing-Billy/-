package com.baizhi.travels.dao;

import com.baizhi.travels.entity.Place;
import com.baizhi.travels.entity.Team;
import com.baizhi.travels.entity.Type;
import com.baizhi.travels.entity.UserCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlaceDAO extends BaseDAO<Place,String> {


    List<Place>  findByProvinceIdPage(@Param("start") Integer start,@Param("rows") Integer rows,@Param("provinceId") String provinceId);


    Integer findByProvinceIdCounts(String provinceId);

    List<Type> findtypes();

    List<Place> findOneByname(String sname);

    String findProvince(String pid);

    List<Place> findPlaceByUlike(@Param("param1") String param1,@Param("param2") String param2,@Param("param3") String param3,@Param("param4") String param4);

    List<Place> findRankAll();

    UserCollection findCollection(@Param("fcid") Integer id, @Param("fcname") String sname);

    void collectspot(@Param("csid") Integer id,@Param("csname") String sname);

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
