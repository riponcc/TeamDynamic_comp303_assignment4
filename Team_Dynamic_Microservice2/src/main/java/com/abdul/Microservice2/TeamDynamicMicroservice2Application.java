package com.abdul.Microservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TeamDynamicMicroservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(TeamDynamicMicroservice2Application.class, args);
		
		System.setProperty("spring.config.name", "Team-Dynamic-Microservice2");
		
		System.out.println("Microservice 2 Started on Port 8084...");
    }

    @Bean
    @LoadBalanced
    WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
