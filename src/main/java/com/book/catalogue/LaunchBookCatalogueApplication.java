package com.book.catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.book.catalogue, "
		+ "com.book.catalogue.controller, com.book.catalogue.service, com.book.catalogue.swagger")
@SpringBootApplication
public class LaunchBookCatalogueApplication {

	//http://localhost:8080/swagger-ui.html#/
	public static void main(String[] args) {
		SpringApplication.run(LaunchBookCatalogueApplication.class, args);
	}
}
