package com.baizhi.travels.service;

import com.baizhi.travels.dao.UserDAO;
import com.baizhi.travels.entity.Admin;
import com.baizhi.travels.entity.Place;
import com.baizhi.travels.entity.Province;
import com.baizhi.travels.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public User findOne(int id) {
        return userDAO.findOne(id);
    }

    @Override
    public void delete(int id) {
        //删除景点信息
        userDAO.delete(id);
    }

    public Integer findAllUserCounts(){
        return userDAO.findAllUserCounts();
    };

    @Override
    public List<User> findAllUserPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return userDAO.findAllUserPage(start,rows);
    }

    public Admin adminfind(String name,String password){
        Admin admin=userDAO.findAdmin(name);
        if(admin!=null){
            if(admin.getPassword().equals(password)){
                return admin;
            }
            throw new RuntimeException("密码输入错误~~~");
        }else{
            throw new RuntimeException("管理名输入错误!!!");
        }
    }

    @Override
    public User login(User user) {
        User userDB = userDAO.findByUsername(user.getUname());
        if(userDB!=null){
            if(userDB.getUpassword().equals(user.getUpassword())){
                return userDB;
            }
            throw new RuntimeException("密码输入错误~~~");
        }else{
            throw new RuntimeException("用户名输入错误!!!");
        }
    }

    @Override
    public void register(User user) {
        if (userDAO.findByUsername(user.getUname()) == null) {
            userDAO.save(user);
        }else{
            throw new RuntimeException("用户名已经存在~~~~");
        }
    }

    @Override
    public void modify(User user){
        userDAO.modify(user);
    }
}
