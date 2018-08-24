package com.cast.recruit.repository;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created By GuuBohan.
 * On 2018/8/8
 */
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        //登录(update,index,register,success)不做拦截
        if (request.getRequestURI().equals("/update") || request.getRequestURI().equals("/index") || request.getRequestURI().equals("/register") || request.getRequestURI().equals("/success")){
            return true;
        }

        //验证session是否存在
        Object o = request.getSession().getAttribute("session_student");
        if (o == null){
            response.sendRedirect("update");
            return false;
        }
        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
}
