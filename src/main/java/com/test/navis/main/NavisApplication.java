package com.test.navis.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.test.navis.*")
public class NavisApplication  {

	public static void main(String[] args) {
		SpringApplication.run	(NavisApplication.class, args);
	
	}

	

}
