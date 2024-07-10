package com.example.smspr.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("")
@Controller
public class DefaultPageController {

    //2024-07-09
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }


    //2024-07-10
    @GetMapping({"", "/", "/index2"})
    public String empty(){
        //return "index";
        return "redirect:/index";
    }

    @GetMapping("/page1")
    public String page1(){
        return "page1";
    }


}