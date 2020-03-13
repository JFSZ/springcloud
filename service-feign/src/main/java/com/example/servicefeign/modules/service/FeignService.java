package com.example.servicefeign.modules.service;

import com.example.servicefeign.modules.service.impl.FeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: chenxue
 * @create: 2020-01-15 16:27
 **/
@FeignClient(value = "service-hi",fallback = FeignServiceImpl.class)
public interface FeignService {
    @RequestMapping("/eurekaClient/hi")
    String hello(@RequestParam("name") String name);
}
