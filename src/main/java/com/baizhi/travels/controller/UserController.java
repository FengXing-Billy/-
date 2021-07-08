package com.baizhi.travels.controller;
import com.baizhi.travels.entity.Admin;
import com.baizhi.travels.entity.Place;
import com.baizhi.travels.entity.Result;
import com.baizhi.travels.entity.User;
import com.baizhi.travels.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin(allowCredentials = "true") //允许跨域
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findOne")
    public User findOne(int id){
        User user=userService.findOne(id);
        return user;
    }

    @RequestMapping("login")
    public Result login(@RequestBody User user,HttpServletRequest request) {
        Result result = new Result();
        try {
            //先判断是否为管理员
            if(user.getUname().substring(0,1).equals("_")){
                Admin admin = userService.adminfind(user.getUname(),user.getUpassword());
                result.setMsg(admin.getName());
            }else {
            User userDB = userService.login(user);
            //登录成功之后保存用户的标记 ServletContext application Redis userid userdb
            request.getServletContext().setAttribute(userDB.getUid()+"",userDB);
            result.setUserId(userDB.getUid());}
        } catch (Exception e) {
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }


    //用户注册
    @PostMapping("register")
    public Result register(@RequestBody User user, HttpServletRequest request) {
        Result result = new Result();
        try {
                //注册用户
                userService.register(user);
                result.setMsg("注册成功!!!");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }


    @GetMapping("findAllUser")
    public Map<String, Object> findAllUser(Integer page, Integer rows) {
        HashMap<String, Object> result = new HashMap<>();
        page = page == null ? 1 : page;
        rows = rows == null ? 5 : rows;

        //景点集合
        List<User> users = userService.findAllUserPage(page, rows);
        //处理分页
        Integer counts = userService.findAllUserCounts();
        //总页数
        Integer totalPage = counts % rows == 0 ? counts / rows : counts / rows + 1;
        result.put("users", users);
        result.put("page", page);
        result.put("counts", counts);
        result.put("totalPage", totalPage);
        System.out.println(counts);
        return result;
    }

    @GetMapping("delete")
    public Result delete(int id){
        Result result = new Result();
        try{
            userService.delete(id);
            result.setMsg("注销用户成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }

    @PostMapping("save")
    public void Save(@RequestBody User user){
        System.out.println(user);
        userService.modify(user);
    }
}
