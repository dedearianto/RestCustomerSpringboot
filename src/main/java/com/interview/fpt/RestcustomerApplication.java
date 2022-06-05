package com.interview.fpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class RestcustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestcustomerApplication.class, args);
	}

}
