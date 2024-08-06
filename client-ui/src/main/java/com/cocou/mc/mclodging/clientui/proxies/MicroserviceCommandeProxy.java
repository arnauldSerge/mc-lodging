package com.cocou.mc.mclodging.clientui.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cocou.mc.mclodging.clientui.beans.CommandeBean;

@FeignClient(name = "order-service", url = "localhost:8082")
public interface MicroserviceCommandeProxy {
    @PostMapping(value = "api/orders")
    CommandeBean ajouterCommande(@RequestBody CommandeBean commande);
}
