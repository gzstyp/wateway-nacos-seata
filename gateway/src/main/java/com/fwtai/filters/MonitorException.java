package com.fwtai.filters;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 统一异常处理,示例代码
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2021/3/8 14:35
 * @QQ号码 444141300
 * @Email service@yinlz.com
 * @官网 <url>http://www.yinlz.com</url>
*/
public class MonitorException implements WebExceptionHandler{

    public MonitorException(final List<ViewResolver> viewResolvers,final ServerCodecConfigurer configurer) {
        System.out.println("viewResolvers = " + viewResolvers);
        System.out.println("configurer = " + configurer);
    }

    @Override
    public Mono<Void> handle(final ServerWebExchange exchange,final Throwable ex) {
        final ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().add("Content-Type","text/html;charset=utf-8");
        final byte[] datas = "{\"code\":199,\"msg\":\"API接口被限流\"}".getBytes(StandardCharsets.UTF_8);
        final DataBuffer buffer = response.bufferFactory().wrap(datas);
        System.out.println("ex-->" + ex.getMessage());
        return response.writeWith(Mono.just(buffer));
    }
}