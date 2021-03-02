package com.fwtai.controller;

import com.fwtai.ProviderService;
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

    // 提供给'消费者'调用的 http://127.0.0.1:9092/consumer/yinlz.com 本地调用 http://127.0.0.1:8081/provider/yinlz.com
    @GetMapping(value = "/{message}")
    public String message(@PathVariable String message) {
        return providerService.message(message);
    }

    // 从上下文中读取配置,http://127.0.0.1:8081/provider/getName
    @GetMapping(value = "/getName")
    public String getName(){
        final String name = providerService.getName();
        return "Hello 通过 @Value注解获取 " + name +",注意：通过注解获取的值是之前的值,想要拿到最新的值需要重启应用或通过applicationContext.getEnvironment().getProperty(\"user.name\")"+ providerService.environmentValue();
    }
}