package com.TeamDynamic.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class TeamDynamicEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamDynamicEurekaServerApplication.class, args);
        System.out.println("Eureka Server started.....");
	}

}
