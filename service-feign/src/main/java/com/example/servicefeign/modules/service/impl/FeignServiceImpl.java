package com.example.servicefeign.modules.service.impl;

import com.example.servicefeign.modules.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chenxue
 * @create: 2020-01-16 14:24
 **/
@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public String hello(String name) {
        return "error-- " + name;
    }
}
