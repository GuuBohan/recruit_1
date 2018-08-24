package com.cast.recruit.controller;

import com.cast.recruit.model.User;
import com.cast.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created By GuuBohan.
 * On 2018/8/8
 */
@Controller
@RequestMapping("/updateInfo")
public class UpdateInfoController {
    private UserService userService;

    @Autowired
    public UpdateInfoController(UserService userService){this.userService = userService;}

    @ResponseBody
    @RequestMapping(value = "/B17011429",method = RequestMethod.GET)
    public User updateInfo(String studentID, HttpServletRequest request){
        studentID = (String) request.getSession().getAttribute("student_session");
        System.out.println(studentID);
        return userService.findUserByID(studentID);
    }

//    @RequestMapping(method = RequestMethod.POST)
    @RequestMapping(method = RequestMethod.POST)
    public String updateInfo(User user){
        userService.updateUser(user);
        return "success";
    }


}
