package com.example.servicio_vitales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServicioVitalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioVitalesApplication.class, args);
	}

}
