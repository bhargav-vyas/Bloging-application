package com.tak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories(basePackages = "com.example.blog.model")
@SpringBootApplication
@ComponentScan("com.example.blog.model")
@EntityScan("com.example.blog.model")
@Repository
public class BlgeTechApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(BlgeTechApplication2.class, args);
	}

}
