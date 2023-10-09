package com.crni99.CovidData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CovidDataApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(CovidDataApplication.class, args);
	}

}
