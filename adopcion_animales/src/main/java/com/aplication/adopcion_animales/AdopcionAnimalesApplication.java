package com.aplication.adopcion_animales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages= {"com.aplication.adopcion_animales.Repositorios"})
@ComponentScan(basePackages = {"com.aplication.adopcion_animales"})
@EntityScan("com.aplication.adopcion_animales.Modelo")
public class AdopcionAnimalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopcionAnimalesApplication.class, args);
	}

}
