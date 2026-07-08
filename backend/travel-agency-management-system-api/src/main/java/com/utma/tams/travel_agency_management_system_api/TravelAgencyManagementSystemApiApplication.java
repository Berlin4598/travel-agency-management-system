package com.utma.tams.travel_agency_management_system_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TravelAgencyManagementSystemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyManagementSystemApiApplication.class, args);
	}

	@Bean 
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
