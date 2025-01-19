package com.gabrielcoding.jpa;

import com.gabrielcoding.jpa.models.Author;
import com.gabrielcoding.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository
	){
		return args -> {

			var author = Author.builder()
					.firstName("Gabriel")
					.lastName("Silva")
					.email("gabriel@mail.com")
					.age(25)
					.build();

			var saved = repository.save(author);
			System.out.print(saved);
		};
	}
}
