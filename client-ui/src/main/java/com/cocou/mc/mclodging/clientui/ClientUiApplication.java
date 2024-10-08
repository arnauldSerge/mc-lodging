package com.cocou.mc.mclodging.clientui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.cocou.mc.mclodging.clientui")
//@EnableDiscoveryClient
public class ClientUiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ClientUiApplication.class, args);
	}
	
}
