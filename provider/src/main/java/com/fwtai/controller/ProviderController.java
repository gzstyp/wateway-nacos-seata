package com.fwtai.controller;

import com.fwtai.service.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/provider")
public class ProviderController{

    @Resource
    private ProviderService providerService;

    // todo 本身的服务通过gateway网关调用方式 http://127.0.0.1:9000/provider/provider/yinlz.com?token=w ok
    //  消费者通过gateway网关调用方式 http://127.0.0.1:9000/consumer/consumer/message?token=w ok
    //  本服务调用方式 http://127.0.0.1:8081/provider/yinlz.com ok
    //  '消费者'调用方式 http://127.0.0.1:9092/consumer/message ok
    @GetMapping(value = "/{message}")
    public String message(@PathVariable String message) {
        return providerService.message(message);
    }

    // 从上下文中读取配置,http://127.0.0.1:8081/provider/getName
    @GetMapping(value = "/getName")
    public String getName(){
        final String name = providerService.getName();
        return "通过 @Value注解获取 " + name +",注意：通过注解获取的值是之前的值,想要拿到最新的值需要重启应用或通过applicationContext.getEnvironment().getProperty(\"user.name\")"+ providerService.environmentValue();
    }
}