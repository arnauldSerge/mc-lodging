package com.cocou.mc.mclodging.clientui.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cocou.mc.mclodging.clientui.beans.ProductBean;
//import com.cocou.mc.mclodging.clientui.configuration.FeignExceptionConfig;

@FeignClient(name = "referentiel-service", url = "localhost:8284")
public interface MicroserviceProduitsProxy {
	@GetMapping(value = "api/products")
	   List<ProductBean> listeDesProduits();

	   @GetMapping( value = "api/products/{id}")
	   ProductBean recupererUnProduit(@PathVariable int id);
}
