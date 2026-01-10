package com.example.springboottutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringboottutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboottutorialApplication.class, args);
	}

}
