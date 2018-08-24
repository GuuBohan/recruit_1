package com.cast.recruit.controller;

import com.alibaba.fastjson.JSONObject;
import com.cast.recruit.model.User;
import com.cast.recruit.service.UserService;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

/**
 * Created By GuuBohan.
 * On 2018/8/7
 */
@Controller
@RequestMapping("/update")
public class UpdateController {

//    Logger logger

    private UserService userService;

    @Autowired
    public UpdateController(UserService userService){ this.userService = userService;}

    @RequestMapping(method = RequestMethod.GET)
    public String update(){
        return "update";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)    //200==成功  406==用户不存在  407==密码错误
    public Integer updateUser(HttpSession session, @RequestBody String data){

        Integer result = 200;

        JSONObject jsonObject = JSONObject.parseObject(data);
        String studentID = jsonObject.getString("studentID");
        String password = jsonObject.getString("password");

//        System.out.println(studentID);
//        System.out.println(password);

            if (userService.userNotnull(studentID) && userService.equalsToPwd(studentID,password)){         //&&具有逻辑短路
                //session中存入studentID
                session.setAttribute("session_student", studentID);
//                String ID = (String) session.getAttribute("session_student");
//                System.out.println(ID);
                session.setMaxInactiveInterval(600);
                return result;
            }
            else if (userService.userNotnull(studentID) == false){
                result = 406;
                return result;
            }
            else {
                result = 407;
                return result;
            }
    }
//    @RequestMapping(method = RequestMethod.POST)
//    public String updateUser(String studentID, String password, HttpSession session, HttpServletResponse response) throws Exception{
//        Integer result = 200;
//        if (userService.userNotnull(studentID) && userService.equalsToPwd(studentID,password)){
//            session.setAttribute("session_student", userService.findUserByID(studentID));
//            response.getWriter().write(result.toString());
//            return null;
//        }
//        else if (userService.userNotnull(studentID) == false){
//            result = 406;
//            response.getWriter().write(result.toString());
//            return null;
//        }
//        else {
//            result = 407;
//            response.getWriter().write(result.toString());
//            return null;
//        }
//    }

//    @ResponseBody
//    @RequestMapping(method = RequestMethod.POST)    //200==成功  406==用户不存在  407==密码错误
//    public void updateUser(String studentID, String password, HttpSession session, HttpServletResponse response){
//
//        Integer result = 200;
//
//        if (userService.userNotnull(studentID) && userService.equalsToPwd(studentID,password)){         //&&具有逻辑短路
//            session.setAttribute("session_student", userService.findUserByID(studentID));
//            response.setStatus(result);
//        }
//        else if (userService.userNotnull(studentID) == false){
//            result = 406;
//
//        }
//        else {
//            result = 407;
//
//        }
//    }

}
