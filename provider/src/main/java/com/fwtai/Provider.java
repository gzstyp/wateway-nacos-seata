package com.fwtai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//服务提供者
@SpringBootApplication
@EnableDiscoveryClient
public class Provider{

    public static void main(final String[] args) {
        SpringApplication.run(Provider.class, args);
    }
}