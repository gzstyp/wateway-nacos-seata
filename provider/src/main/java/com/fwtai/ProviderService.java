package com.fwtai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ProviderService{

    @Value("${user.name}")
    private String name;

    @Value("${server.port}")
    private String port;

    // 注入配置文件上下文
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    public String getName(){
        return name;
    }

    // 注意：通过注解获取的值是之前的值,想要拿到最新的值需要重启应用或通过applicationContext.getEnvironment().getProperty();
    public String environmentValue(){
        return applicationContext.getEnvironment().getProperty("user.name");
    }

    public String message(final String message){
        return "Hello,我是" + message + ",来自端口号 " + port;
    }
}