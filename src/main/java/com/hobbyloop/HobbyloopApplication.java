package com.hobbyloop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HobbyloopApplication {

	public static void main(String[] args) {
		SpringApplication.run(HobbyloopApplication.class, args);
	}

}
