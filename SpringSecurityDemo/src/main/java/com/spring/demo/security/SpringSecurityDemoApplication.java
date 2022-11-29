package com.spring.demo.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.demo.security.entity.Books;
import com.spring.demo.security.repository.booksRepository;


@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}
	CommandLineRunner initDatabase(booksRepository repo) {
		return args -> {
			repo.save(new Books("Book4", 34.00));
		};
	}
}
