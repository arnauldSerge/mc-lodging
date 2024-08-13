package com.cocou.mc.mclodging.clientui.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cocou.mc.mclodging.clientui.beans.PaiementBean;
import com.cocou.mc.mclodging.clientui.configuration.FeignExceptionConfig;

@FeignClient(name = "paiement-service", url = "localhost:8085", configuration = FeignExceptionConfig.class)
public interface MicroservicePaiementProxy {
    @PostMapping(value = "api/paiements")
    ResponseEntity<PaiementBean> payerUneCommande(@RequestBody PaiementBean paiement);
}