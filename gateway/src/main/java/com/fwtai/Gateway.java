package com.fwtai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//本项目spring-cloud-gateway已整合nacos 访问 http://localhost:9000/consumer/test/hi?token=value 说明 Spring Cloud Gateway 的路由功能配置成功
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Gateway{

    public static void main(final String[] args) {
        SpringApplication.run(Gateway.class, args);
    }
}