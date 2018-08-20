package com.cast.recruit.controller;

import com.cast.recruit.model.User;
import com.cast.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(method = RequestMethod.GET)
    public String updateInfo(){
        return "updateInfo";
    }

//    @RequestMapping(method = RequestMethod.POST)
    @RequestMapping(method = RequestMethod.POST)
    public String updateInfo(User user){
        userService.updateUser(user);
        return "success";
    }


}
