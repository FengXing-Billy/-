package com.baizhi.travels.controller;
import com.baizhi.travels.entity.*;
import com.baizhi.travels.service.PlaceService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @Value("${upload.dir}")
    private String realPath;


    /**
     * 修改景点信息
     */
    @PostMapping("update")
    public Result update(MultipartFile pic, Place place) throws IOException {
        Result result = new Result();

        try{
            //处理文件上传
            //如果没有上传图片进行修改,则无需对上传的文件进行处理
            if(pic!=null){
            String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
            String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +"."+ extension;
            pic.transferTo(new File(realPath,newFileName));
            place.setSpicture("../img/pimg/"+newFileName);
            }
            //修改景点信息
            placeService.update(place);
            result.setMsg("修改景点信息成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }

    /**
     * 查询景点信息
     */
    @GetMapping("findOne")
    public Place findOne(String id){
        return placeService.findOne(id);
    }

    /**
     * 删除景点信息
     * @param id
     * @return
     */
    @GetMapping("delete")
    public Result delete(String id){
        Result result = new Result();
        try{
            placeService.delete(id);
            result.setMsg("删除景点信息成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }

    @GetMapping("deletespot")
    public void deletespot(String sid,String uid){
        placeService.deletespot(sid,uid);
    }

    /**
     * 保存景点信息
     *
     * @param pic
     * @return
     */
    @PostMapping("save")
    public Result save(MultipartFile pic, Place place) throws IOException {
        Result result = new Result();
        System.out.println(placeService.findOneByname(place.getSname()));
        try {
            if(placeService.findOneByname(place.getSname()).size()==0){
            //文件上传
            String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
            String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +"."+ extension;
            //文件上传
            File file = new File(realPath);
            pic.transferTo(new File(file,newFileName));
            place.setSpicture("../img/pimg/"+newFileName);
            //保存place对象
            placeService.save(place);
            result.setMsg("保存景点信息成功!!!");}
            else {
                result.setState(false).setMsg("该景点已存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }

    @GetMapping("findtype")
    public List<Type> findtypes(){
        return placeService.findtypes();
    }


    /**
     * 根据省份id查询景点的方法
     */
    @GetMapping("findAllPlace")
    public Map<String, Object> findAllPlace(Integer page, Integer rows, String pid) {
        HashMap<String, Object> result = new HashMap<>();
        page = page == null ? 1 : page;
        rows = rows == null ? 3 : rows;

        String pname=placeService.findProvince(pid);
        //景点集合
        List<Place> places = placeService.findByProvinceIdPage(page, rows, pid);
        //处理分页
        Integer counts = placeService.findByProvinceIdCounts(pid);
        //总页数
        Integer totalPage = counts % rows == 0 ? counts / rows : counts / rows + 1;
        result.put("places", places);
        result.put("page", page);
        result.put("counts", counts);
        result.put("totalPage", totalPage);
        result.put("pname",pname);
        return result;
    }

    @GetMapping("findAllSpot")
    public Map<String, Object> findAllSpot(String pid) {
        HashMap<String, Object> result = new HashMap<>();
        String pname=placeService.findProvince(pid);
        List<Place> spots=placeService.findAllSpot(pid);
        Integer counts=placeService.findSpotCounts(pid);
        List<Place> rankspots=placeService.findRankFive(pid);
        result.put("rankspots",rankspots);
        result.put("spots",spots);
        result.put("pname",pname);
        result.put("scounts",counts);
        return result;
    }

    @GetMapping("require")
    public Map<String, Object> findByRequirement(String pid,String lid,int updown) {
        HashMap<String, Object> result = new HashMap<>();
        List<Place> requirespot = null;
        if(updown==1){
            requirespot=placeService.findRequireAESC(pid,lid);
        }
        if(updown==2){
            requirespot=placeService.findRequireDESC(pid,lid);
        }
        Integer requirecounts=placeService.findRequireCounts(pid,lid);

        result.put("requirespot",requirespot);
        result.put("requirecounts",requirecounts);
        return result;
    }

    @GetMapping("spotandstrategy")
    public Map<String, Object> findspotandstra(String id) {
        HashMap<String, Object> result = new HashMap<>();
        Place spot=placeService.findOne(id);
        List<Team> strategy=placeService.findTeam(id);
        result.put("spot",spot);
        result.put("strategy",strategy);
        return result;
    }

    @GetMapping("remd")
    public List<Place> findrecommend(int id){
        return placeService.findrecommend(id);
    }

    @GetMapping("rank4")
    public List<Place> findrank4(){
        return placeService.findrank4();
    }

    @PostMapping("collect")
    public Result collectSpot(Integer id,String sname){
        Result collectresult = new Result();

            if(placeService.FindCollection(id,sname)==null){
                placeService.collectspot(id,sname);
                collectresult.setMsg("收藏成功!");
            }else{
                collectresult.setMsg("该景点已经收藏过了!");
            }
        return collectresult;
        }
    @GetMapping("collect")
    public List<UserCollection> findCollection(int id){
        return placeService.findcollect(id);
    }

    @GetMapping("findsname")
    public List<Place> findsnames(String sname){
        return placeService.findSnames(sname);
    }
}
