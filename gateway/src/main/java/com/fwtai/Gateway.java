package com.fwtai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 本项目spring-cloud-gateway已整合nacos 访问 http://127.0.0.1:9000/consumer/consumer/message?token=value 说明 Spring Cloud Gateway 的路由功能配置成功,它访问的服务名consumer控制层controller层是 consumer 方法名是 message()
// todo 其调用的是 controller为 consumer 的方法名为 message,它的本地调用 http://127.0.0.1:9092/consumer/message
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Gateway{

    public static void main(final String[] args) {
        SpringApplication.run(Gateway.class, args);
    }
}