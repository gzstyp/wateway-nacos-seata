package com.fwtai.fallback;

import com.fwtai.service.ConsumerService;
import org.springframework.stereotype.Component;

//以 Sentinel 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性
@Component
public class FallbackConsumerServiceImpl implements ConsumerService{ //若实现 implements FallbackFactory<ConsumerService> {

    // 本处的类应该实现接口 implements FallbackFactory<ConsumerService> {}
    /*@Override
    public ConsumerService create(final Throwable cause){
        return new ConsumerService(){
            @Override
            public String message(final String message){
                System.out.println("么么哒");
                return message+"调用失败 fallback,Sentinel已生效,Sentinel 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性,cause:"+cause;
            }
        };
    }*/

    //Sentinel 以流量为切入点，此处是熔断降级效果
    @Override
    public String message(final String message) {
        return message+",调用失败 fallback,Sentinel已生效,Sentinel 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性";
    }
}