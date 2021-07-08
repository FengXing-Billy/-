//package com.baizhi.travels.controller;
//import com.baizhi.travels.entity.Admin;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//    // 目标方法执行之前
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Object admin= request.getSession().getAttribute("AdminLogin");
//        // 如果获取的request的session中的loginUser参数为空（未登录），就返回登录页，否则放行访问
//        if (admin == null) {
//            // 获取request返回页面到登录页
//            request.getRequestDispatcher("/login.html").forward(request, response);
//            return false;
//        } else {
//            return true;
//        }
//    }
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}