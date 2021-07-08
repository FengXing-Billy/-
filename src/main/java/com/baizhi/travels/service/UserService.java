package com.baizhi.travels.service;

import com.baizhi.travels.entity.Admin;
import com.baizhi.travels.entity.Place;
import com.baizhi.travels.entity.User;

import java.util.List;

public interface UserService {

    User findOne(int id);

    void delete(int id);

    List<User> findAllUserPage(Integer page, Integer rows);

    Integer findAllUserCounts();

    User login(User user);

    void register(User user);

    Admin adminfind(String name, String password);

    void modify(User user);
}
