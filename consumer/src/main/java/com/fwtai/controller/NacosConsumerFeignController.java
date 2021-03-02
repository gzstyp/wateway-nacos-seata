package com.fwtai.controller;

import com.fwtai.service.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosConsumerFeignController {

    @Autowired
    private UserFeignService UserFeignService;

    // http://localhost:9092/test/hi
    @GetMapping(value = "/test/hi")
    public String test() {
        return UserFeignService.test("Hi Feign");
    }
}