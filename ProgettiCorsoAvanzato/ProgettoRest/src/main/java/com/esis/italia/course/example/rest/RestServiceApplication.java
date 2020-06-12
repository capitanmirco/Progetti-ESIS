package com.esis.italia.course.example.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@SpringBootApplication
@EnableJpaRepositories("com.esis.italia.course.example.jpa.respository")
@ComponentScan({"com.esis.italia.course.example.jpa"})
@EntityScan("com.esis.italia.course.example.jpa.entity")
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}
}
