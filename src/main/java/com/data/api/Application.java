package com.data.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication //this encompasses @Configuration, @EnableAutoConfiguration, @ComponentScan
@EnableJpaRepositories //this enables Spring Data
public class Application extends SpringBootServletInitializer {
	
	//Spring Boot deploys itself. 
	//spins up a tomcat server to run the Restful webservice

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args); 
	} 
}