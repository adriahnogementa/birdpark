package com.birdpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BirdparkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirdparkApplication.class, args);
	}

	/**
	 * Das ist nur eine Methode für Cross-Origin, also dass auf einem Pc der eine Port (React) auf den andern Port (Backend) zugreifen kann
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		};
	}
}
