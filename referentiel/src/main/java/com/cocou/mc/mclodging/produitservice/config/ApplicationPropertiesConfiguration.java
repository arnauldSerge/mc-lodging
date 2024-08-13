package com.cocou.mc.mclodging.produitservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@ConfigurationProperties("mes-configs")
@Data
public class ApplicationPropertiesConfiguration 
{
  private int limitDeProduits;
}
