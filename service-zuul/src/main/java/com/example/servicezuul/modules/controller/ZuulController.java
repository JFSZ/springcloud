package com.example.servicezuul.modules.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenxue
 * @create: 2020-01-19 14:13
 **/
@RestController
public class ZuulController {
    @RequestMapping("/test")
    public String zuul(){
        return "test";
    }
}
