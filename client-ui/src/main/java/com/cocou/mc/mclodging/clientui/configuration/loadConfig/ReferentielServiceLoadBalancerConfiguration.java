package com.cocou.mc.mclodging.clientui.configuration.loadConfig;


import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@LoadBalancerClient(name = "referentiel-service", configuration = MyServiceReferentielLoadBalancerConfiguration.class)
public class ReferentielServiceLoadBalancerConfiguration {
	@Bean
    public RandomLoadBalancer randomReferentielLoadBalancer(LoadBalancerClientFactory clientFactory) {
        return new RandomLoadBalancer(clientFactory.getLazyProvider("referentiel-service", ServiceInstanceListSupplier.class), "referentiel-service");
    }
}
