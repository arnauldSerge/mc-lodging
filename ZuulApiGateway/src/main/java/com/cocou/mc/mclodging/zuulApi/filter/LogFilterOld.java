package com.cocou.mc.mclodging.zuulApi.filter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
@Component
public class LogFilterOld implements GlobalFilter, Ordered {
    private static final Logger logger = LogManager.getLogger(LogFilterOld.class);
    
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        logger.info("Request Path: {}", request.getURI().getPath());
        logger.info("Request Method: {}", request.getMethod());

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            logger.info("Response Status Code: {}", response.getStatusCode());
        }));
    }

    @Override
    public int getOrder() {
        return -1; // This ensures the filter runs early
    }

}
