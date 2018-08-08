package com.cast.recruit.controller;

import com.cast.recruit.model.User;
import com.cast.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By GuuBohan.
 * On 2018/8/7
 */
@RestController
@RequestMapping("/update")
public class UpdateController {
    private UserService userService;

    @Autowired
    public UpdateController(UserService userService){ this.userService = userService;}

    @RequestMapping(method = RequestMethod.POST, value = "")
    public String updateUser(User user){
            if (userService.userNotnull(user.getStudentID(),user.getPhoneNumber())){
                userService.updateUser(user);
                return "success";
            }
            else
                return "You should register first.";
    }

}
