package com.example.serverribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class ServerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerRibbonApplication.class, args);
    }

}
