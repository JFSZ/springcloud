package com.example.serverribbon.demo.controller;

import com.example.serverribbon.demo.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenxue
 * @create: 2020-01-15 11:56
 **/
@RestController
@RequestMapping("/ribbon")
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;

    @RequestMapping("/test")
    public String test(@RequestParam("name") String name){
        return ribbonService.callEurekaClient(name);
    }

}
