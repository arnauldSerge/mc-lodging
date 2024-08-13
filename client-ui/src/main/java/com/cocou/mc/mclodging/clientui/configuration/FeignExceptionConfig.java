package com.cocou.mc.mclodging.clientui.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cocou.mc.mclodging.clientui.exception.CustomErrorDecoder;

@Configuration
public class FeignExceptionConfig {

    @Bean
   CustomErrorDecoder mCustomErrorDecoder(){
       return new CustomErrorDecoder();
   }
}
