package com.fwtai.service;

import com.fwtai.fallback.FallbackUserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// todo 以 Sentinel 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性。但默认是关闭的。需要在配置文件中配置打开它启用它
//通过 @FeignClient("服务名") 注解来指定调用哪个服务;在 Service 中@FeignClient注解增加 fallback 属性用来指定类,以 Sentinel 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性。
@FeignClient(value = "nacos-provider", fallback = FallbackUserServiceImpl.class)
public interface UserFeignService{

    @GetMapping(value = "/test/{message}")
    String test(@PathVariable("message") String message);
}