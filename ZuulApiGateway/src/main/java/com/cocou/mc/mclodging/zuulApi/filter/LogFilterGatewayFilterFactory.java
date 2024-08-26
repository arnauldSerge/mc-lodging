package com.cocou.mc.mclodging.zuulApi.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import lombok.Data;
import reactor.core.publisher.Mono;

@Component
public class LogFilterGatewayFilterFactory extends AbstractGatewayFilterFactory<LogFilterGatewayFilterFactory.Config> {

    private static final Logger logger = LogManager.getLogger(LogFilterGatewayFilterFactory.class);

    public LogFilterGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            logger.info("Request Path: {}", exchange.getRequest().getURI().getPath());
            logger.info("Request Method: {}", exchange.getRequest().getMethod());

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("Response Status Code: {}", exchange.getResponse().getStatusCode());
            }));
        };
    }
    @Data
    public static class Config {
        // Configuration properties for the filter can go here if needed.
    	//private boolean logHeaders;
        //private boolean logParams;
    }
}
