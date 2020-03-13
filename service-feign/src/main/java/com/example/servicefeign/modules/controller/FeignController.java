package com.example.servicefeign.modules.controller;

import com.example.servicefeign.modules.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenxue
 * @create: 2020-01-15 16:46
 **/
@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private FeignService feignService;

    @RequestMapping("/callFeign")
    public String callFeign(@RequestParam("name") String name){
        return feignService.hello(name);
    }
}
