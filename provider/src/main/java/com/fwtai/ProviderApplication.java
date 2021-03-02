package com.fwtai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//服务提供者
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication{

    public static void main(final String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}