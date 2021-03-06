package org.mysise.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MysiseGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysiseGatewayApplication.class, args);
	}
}
