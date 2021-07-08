package com.baizhi.travels.service;

import com.baizhi.travels.dao.PlaceDAO;
import com.baizhi.travels.dao.UserDAO;
import com.baizhi.travels.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {
    @Resource
    private UserDAO userDAO;

    @Resource
    private PlaceDAO placeDAO;

    @Override
    public void update(Place place) {
        placeDAO.update(place);
    }

    @Override
    public Place findOne(String id) {
        return placeDAO.findOne(id);
    }

    @Autowired
    private ProvinceService provinceService;

    @Override
    public void delete(String id) {
        //直接删除景点  更新省份景点个数 删除景点
        Place place = placeDAO.findOne(id);
        Province province = provinceService.findOne(place.getPid()+"");
        province.setPcounts(province.getPcounts()-1);
        provinceService.update(province);
        //删除景点信息
        placeDAO.delete(id);
    }

    @Override
    public void save(Place place) {
        //保存景点
        placeDAO.save(place);
        //查询原始省份信息
        Province province = provinceService.findOne(place.getPid()+"");
        //更新省份信息的景点个数
        province.setPcounts(province.getPcounts()+1);
        provinceService.update(province);

    }

    @Override
    public List<Place> findByProvinceIdPage(Integer page, Integer rows, String provinceId) {
        int start = (page-1)*rows;
        return placeDAO.findByProvinceIdPage(start,rows,provinceId);
    }
    @Override
    public List<Type> findtypes(){
        return placeDAO.findtypes();
    }

    @Override
    public List<Place> findOneByname(String sname) {
        return placeDAO.findOneByname(sname);
    }

    @Override
    public Integer findByProvinceIdCounts(String provinceId) {
        return placeDAO.findByProvinceIdCounts(provinceId);
    }

    @Override
    public String findProvince(String pid) {
        return placeDAO.findProvince(pid);
    }

    //推荐景点
    public List<Place> findrecommend(int id){
        User user=userDAO.findOne(id);
        String[] ulike=new String[4];
        String[] split = user.getUlike().split(",");
        for (int i = 0; i < split.length; i++) {
            ulike[i]=split[i];
        }
        return placeDAO.findPlaceByUlike(ulike[0],ulike[1],ulike[2],ulike[3]);
    }

    public List<Place> findrank4(){
        return placeDAO.findRankAll();
    }

    public UserCollection FindCollection(Integer id, String sname){
       return placeDAO.findCollection(id,sname);
    }

    public void collectspot(Integer id, String sname){
        placeDAO.collectspot(id,sname);
    }

    public List<UserCollection> findcollect(int id){
      return  placeDAO.findcollect(id);
    }

    public List<Place> findAllSpot(String id){
        return placeDAO.findAllSpot(id);
    }

    public Integer findSpotCounts(String id){
        return placeDAO.findSpotCounts(id);
    }

    public List<Place> findRankFive(String pid){
        return placeDAO.findRankFive(pid);
    }

    public List<Team> findTeam(String id){
        return placeDAO.findTeam(id);
    }

    public void deletespot(String sid, String uid){
        placeDAO.deletespot(sid,uid);
    }

    public Integer findRequireCounts(String pid, String lid){
        return placeDAO.findRequireCounts(pid,lid);
    }

    public List<Place> findRequireAESC(String pid, String lid){
        return placeDAO.findRequireAESC(pid,lid);
    }

    public List<Place> findRequireDESC(String pid, String lid){
        return placeDAO.findRequireDESC(pid,lid);
    }

    public List<Place> findSnames(String sname){
        return placeDAO.findSnames(sname);
    }
}
