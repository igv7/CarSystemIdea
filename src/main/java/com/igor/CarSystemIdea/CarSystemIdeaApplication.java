package com.igor.CarSystemIdea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories
@EnableMongoRepositories
@EnableScheduling
//@EnableWebSecurity
public class CarSystemIdeaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSystemIdeaApplication.class, args);
		System.out.println("Start CarSystemIdea");
	}

}
