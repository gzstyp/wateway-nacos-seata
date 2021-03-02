package com.fwtai.fallback;

import com.fwtai.service.UserFeignService;
import org.springframework.stereotype.Component;

//以 Sentinel 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性
@Component
public class FallbackUserServiceImpl implements UserFeignService{

    //Sentinel 以流量为切入点，此处是熔断降级效果
    @Override
    public String test(final String message) {
        return message+"调用失败 fallback,Sentinel已生效,Sentinel 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性";
    }
}