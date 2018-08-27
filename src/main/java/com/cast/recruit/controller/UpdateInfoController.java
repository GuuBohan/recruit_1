package com.cast.recruit.controller;

import com.alibaba.fastjson.JSONObject;
import com.cast.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

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

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Integer update(@RequestBody String data, HttpServletRequest request){

        Integer result = 200;

        JSONObject jsonObject = JSONObject.parseObject(data);
        String studentID = jsonObject.getString("studentID");
        String studentName = jsonObject.getString("studentName");
        Long phoneNumber = jsonObject.getLong("phoneNumber");
        String intention_1 = jsonObject.getString("intention_1");
        String intention_2 = jsonObject.getString("intention_2");

        String trueID = (String)request.getSession().getAttribute("session_student");

        System.out.println(trueID);
        System.out.println(data);
        System.out.println(studentID);

        if (studentID.equals(trueID)){
            userService.update(studentID, studentName, phoneNumber, intention_1, intention_2);
            return result;
        }
        else{
            result = 408;
            return result;
        }
    }

//    @ResponseBody
//    @RequestMapping(method = RequestMethod.GET)
//    public User updateInfo(HttpServletRequest request){
//        String studentID = (String) request.getSession().getAttribute("session_student");
//        System.out.println(studentID);

//        JSONObject jsonObject = new JSONObject();
//        response.getWriter().write(jsonObject.getString(userService.findUserByiD(studentID)));

//        return userService.findUserByID(studentID);
//    }

}
