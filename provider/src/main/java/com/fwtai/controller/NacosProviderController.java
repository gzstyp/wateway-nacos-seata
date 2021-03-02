package com.fwtai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosProviderController{

    @Value("${server.port}")
    private String port;

    @Value("${user.name}")
    private String name;

    // 注入配置文件上下文
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    // 提供给远程调用的 http://localhost:9092/test/hi 或 http://localhost:9091/test/app/name
    @GetMapping(value = "/test/{message}")
    public String test(@PathVariable String message) {
        return "Hello Nacos Discovery " + message + " i am from port " + port;
    }

    // 从上下文中读取配置,http://localhost:8081/hi
    @GetMapping(value = "/hi")
    public String sayHi() {
        return "Hello 通过 @Value注解获取 " + name +",注意：通过注解获取的值是之前的值,想要拿到最新的值需要重启应用或通过applicationContext.getEnvironment().getProperty(\"user.name\")"+ applicationContext.getEnvironment().getProperty("user.name");
    }
}