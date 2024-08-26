package com.cocou.mc.mclodging.clientui.configuration;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Configuration;

import com.cocou.mc.mclodging.clientui.configuration.loadConfig.ReferentielServiceLoadBalancerConfiguration;
import com.cocou.mc.mclodging.clientui.configuration.loadConfig.OrderServiceLoadBalancerConfiguration;
import com.cocou.mc.mclodging.clientui.configuration.loadConfig.PaiementServiceLoadBalancerConfiguration;

@Configuration
@LoadBalancerClients({
	@LoadBalancerClient(name = "referentiel-service", configuration = ReferentielServiceLoadBalancerConfiguration.class),
    @LoadBalancerClient(name = "order-service", configuration = OrderServiceLoadBalancerConfiguration.class),
    @LoadBalancerClient(name = "paiement-service", configuration = PaiementServiceLoadBalancerConfiguration.class)
})
public class LoadBalancerConfiguration {

}
