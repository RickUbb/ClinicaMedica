package com.microservice.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// si añadimos en appointment estamos diciendo que el appointment le hare requerimiento a los doctor

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceDoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDoctorApplication.class, args);
	}

}
