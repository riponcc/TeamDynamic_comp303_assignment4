package com.ripon.spring.boot.web.mondb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TeamDynamicMicroservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(TeamDynamicMicroservice1Application.class, args);
		 System.setProperty("spring.config.name", "Spring Web Flux Mongodb Ice Hockey using thymeleaf");
			
		 System.out.println("Spring Boot WebFlux Microservice1 has been satrted!!");
	}

}
