package com.fwtai.controller;

import com.fwtai.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController{

    @Autowired
    private ConsumerService ConsumerService;

    // 本地调用 http://127.0.0.1:9092/consumer/getName
    @GetMapping(value = "/getName")
    public String getName(){
        return ConsumerService.message("消费者服务名ConsumerService,发起的调用->但是呢，说的端口不是我的!!!");
    }
}