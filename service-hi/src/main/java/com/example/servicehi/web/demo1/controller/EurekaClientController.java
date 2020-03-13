package com.example.servicehi.web.demo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenxue
 * @create: 2020-01-15 11:51
 **/
@RestController
@RequestMapping(("/eurekaClient"))
public class EurekaClientController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String sayHi(@RequestParam("name") String name){
        return "Hello:" + name + "I'm from port:" + port;
    }
}
