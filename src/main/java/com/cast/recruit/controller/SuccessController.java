package com.cast.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By GuuBohan.
 * On 2018/8/8
 */
@Controller
@RequestMapping("/success")
public class SuccessController {
    public String success(){
        return "success";
    }
}
