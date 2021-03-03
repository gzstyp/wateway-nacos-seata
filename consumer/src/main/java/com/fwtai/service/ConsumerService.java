package com.fwtai.service;

import com.fwtai.fallback.FallbackConsumerServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// todo 以 Sentinel 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性。但默认是关闭的。需要在配置文件中配置打开它启用它
//通过 @FeignClient("服务名") 注解来指定调用哪个服务;在 Service 中@FeignClient注解增加 fallback 属性用来指定类,以 Sentinel 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性。
@FeignClient(value = "provider", fallback = FallbackConsumerServiceImpl.class)
public interface ConsumerService{

    //调用 provider服务的controller为 provider 的方法名message()，
    // todo 通过gateway网关路由调用的 http://127.0.0.1:9000/consumer/consumer/message?token=w
    @GetMapping(value = "/provider/{message}")
    String message(@PathVariable("message") String message);
}