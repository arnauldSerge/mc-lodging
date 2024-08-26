package com.cocou.mc.mclodging.clientui.configuration.loadConfig;


import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@LoadBalancerClient(name = "referentiel-service", configuration = MyServiceReferentielLoadBalancerConfiguration.class)
public class OrderServiceLoadBalancerConfiguration {
	@Bean
    public RandomLoadBalancer randomOrderServiceLoadBalancer(LoadBalancerClientFactory clientFactory) {
        return new RandomLoadBalancer(clientFactory.getLazyProvider("order-service", ServiceInstanceListSupplier.class), "order-service");
    }
	/**
	@Bean
    public RoundRobinLoadBalancer myCustomLoadBalancer(LoadBalancerClientFactory clientFactory) {
        return new RoundRobinLoadBalancer(clientFactory.getLazyProvider("order-service", ServiceInstanceListSupplier.class), "order-service");
    }**/
}
