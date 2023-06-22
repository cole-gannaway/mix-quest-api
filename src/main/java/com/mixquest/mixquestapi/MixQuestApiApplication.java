package com.mixquest.mixquestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mixquest.mixquestapi.*")
public class MixQuestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MixQuestApiApplication.class, args);
	}

}
