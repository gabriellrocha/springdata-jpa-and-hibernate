package com.gabrielcoding.jpa;

import com.gabrielcoding.jpa.models.Author;
import com.gabrielcoding.jpa.repositories.AuthorRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

//			Faker faker = new Faker();
//			for (int i = 0; i < 40; i++) {
//
//				var author = Author.builder()
//						.firstName(faker.name().firstName())
//						.lastName(faker.name().lastName())
//						.age(faker.number().numberBetween(18, 70))
//						.email(faker.internet().emailAddress())
//						.build();
//
//				repository.save(author);
//			}

			List<Author> l1 = repository.findAllByFirstNameIgnoreCase("jackson");
			List<Author> l2 = repository.findAllByFirstNameEndsWithIgnoreCase("a");
			List<Author> l3 = repository.findAllByFirstNameStartsWithIgnoreCase("g");

			l1.forEach(System.out::println);
			l2.forEach(System.out::println);
			l3.forEach(System.out::println);

		};
	}
}
