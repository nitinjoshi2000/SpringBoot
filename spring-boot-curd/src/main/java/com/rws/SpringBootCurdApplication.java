package com.rws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCurdApplication.class, args);
		System.out.println("Server is up");
	}

}
