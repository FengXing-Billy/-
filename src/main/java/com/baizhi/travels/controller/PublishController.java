package com.baizhi.travels.controller;

import com.baizhi.travels.entity.Result;
import com.baizhi.travels.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("publicInfo")
@CrossOrigin(allowCredentials = "true") //允许跨域
@Slf4j
public class PublishController {

    @RequestMapping("news")
       public String getNews(HttpSession session){
        String ptext = "";
        if(session.getAttribute("ptext").toString()==null){
            ptext = "";
        }else{
            ptext=session.getAttribute("ptext").toString();
        }
        return ptext;
    }
    @RequestMapping("publish")
    public void login(String ptext, HttpSession session) {
        session.setMaxInactiveInterval(120*60);
        session.setAttribute("ptext",ptext);
    }
}
