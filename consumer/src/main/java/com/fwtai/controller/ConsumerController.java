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

    // todo 本身的服务调用方式 http://127.0.0.1:9092/consumer/message ok
    //  通过gateway网关调用方式 http://127.0.0.1:9000/consumer/consumer/message?token=w0 ok

    @GetMapping(value = "/message")
    public String message(){
        return ConsumerService.message("消费者服务名ConsumerService,发起的调用->但是呢，说的端口不是我的!!!");
    }
}