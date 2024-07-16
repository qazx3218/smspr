package com.example.smspr.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tbuser")
public class TbuserPageController {

    //2024-07-10
    @GetMapping("/{page}")
    public String page(@PathVariable String page) {
        return "tbuser/" + page;
    }
}
