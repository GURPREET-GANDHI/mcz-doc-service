package com.mcz.docservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mcz.*")
public class DocserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocserviceApplication.class, args);
	}

}
