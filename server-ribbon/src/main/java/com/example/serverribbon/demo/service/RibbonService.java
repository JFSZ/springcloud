package com.example.serverribbon.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: chenxue
 * @create: 2020-01-15 13:31
 **/
@Service
public class RibbonService {
    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "callError")
    public String callEurekaClient(String name){
        //http://SERVICE-HI/hi?name=
        return restTemplate.getForObject("http://SERVICE-HI/eurekaClient/hi?name=" + name,String.class);
    }

    public String callError(String name){
        return name + "error";
    }
}
