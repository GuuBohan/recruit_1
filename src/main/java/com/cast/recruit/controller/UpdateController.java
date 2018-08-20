package com.cast.recruit.controller;

import com.cast.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;

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

//    @RequestMapping(method = RequestMethod.GET)
//    public String update(){
//        return "update";
//    }

//    @RequestMapping(method = RequestMethod.POST)    //200==成功  406==用户不存在  407==密码错误
//    public String updateUser(String studentID, String password, HttpServletRequest request){
////        Boolean flag = false;
//        Integer result = 200;
//            if (userService.userNotnull(studentID) && userService.equalsToPwd(studentID,password)){         //&&具有逻辑短路
//                request.getSession().setAttribute("session_student", userService.findUserByID(studentID));
//                return result.toString();
//            }
//            else if (userService.userNotnull(studentID) == false){
//                result = 406;
//                return result.toString();
//            }
//            else {
//                result = 407;
//                return result.toString();
//            }
//    }
    @RequestMapping(method = RequestMethod.POST)
    public Integer updateUser(String studentID, String password, HttpSession session){
        Integer result = 200;
        if (userService.userNotnull(studentID) && userService.equalsToPwd(studentID,password)){
            session.setAttribute("session_student", userService.findUserByID(studentID));
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

}
