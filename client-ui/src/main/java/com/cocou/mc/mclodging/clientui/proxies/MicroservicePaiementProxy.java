package com.cocou.mc.mclodging.clientui.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cocou.mc.mclodging.clientui.beans.PaiementBean;

@FeignClient(name = "paiement-service", url = "localhost:8005")
public interface MicroservicePaiementProxy {
    @PostMapping(value = "api/paiement")
    ResponseEntity<PaiementBean> payerUneCommande(@RequestBody PaiementBean paiement);
}
