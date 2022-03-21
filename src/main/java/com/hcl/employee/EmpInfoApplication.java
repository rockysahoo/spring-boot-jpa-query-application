package com.hcl.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories("com.hcl.employee.dao")
public class EmpInfoApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmpInfoApplication.class, args);

	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
