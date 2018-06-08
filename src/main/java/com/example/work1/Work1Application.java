package com.example.work1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class Work1Application {

	public static void main(String[] args) {
		SpringApplication.run(Work1Application.class, args);
	}
}
