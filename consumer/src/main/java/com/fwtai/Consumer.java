package com.fwtai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//本项目是服务消费者,已整合Feign
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//整合Feign
public class Consumer{

    public static void main(final String[] args) {
        SpringApplication.run(Consumer.class, args);
    }
}