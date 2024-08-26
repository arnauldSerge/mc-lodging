package com.cocou.mc.mclodging.clientui.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cocou.mc.mclodging.clientui.beans.CommandeBean;
import com.cocou.mc.mclodging.clientui.configuration.FeignExceptionConfig;

@FeignClient(name = "order-service")
public interface MicroserviceCommandeProxy {
    @PostMapping(value = "api/orders/createOrder")
    CommandeBean ajouterCommande(@RequestBody CommandeBean commande);
}
