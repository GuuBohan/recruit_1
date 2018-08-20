package com.cast.recruit.controller;

import com.cast.recruit.model.User;
import com.cast.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created By GuuBohan.
 * On 2018/7/22
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    private UserService userService;

    @Autowired
    private RegisterController(UserService userService){this.userService = userService;}

    @RequestMapping(method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegister(User user, Errors errors){
        if (errors.hasErrors()){
            return "register";
        }
        else {
            if (userService.userNotnull(user.getStudentID()))        //判断是否重复注册
                return "You shouldn't register repeatedly.";
            else{
                userService.register(user);
                return "success";
            }
        }
    }
}
