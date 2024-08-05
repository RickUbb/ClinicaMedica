package com.microservice.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


// si añadimos en appointment estamos diciendo que el appointment le hare requerimiento a los pacientes
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicePatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePatientApplication.class, args);
	}

}