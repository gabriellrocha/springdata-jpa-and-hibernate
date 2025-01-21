package com.gabrielcoding.jpa;

import com.gabrielcoding.jpa.models.Author;
import com.gabrielcoding.jpa.repositories.AuthorRepository;
import com.gabrielcoding.jpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

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

//			var author = Author.builder()
//					.id(1)
//					.firstName("biel")
//					.email("biel@email.com")
//					.age(50)
//					.build();
//
//			repository.save(author); métoodo save realizar uma consulta de atualização ou consulta de inserção

//			repository.updateAuthor(70, 1);
//
//			// namedQuery
//			repository.findBy(30).forEach(System.out::println);
//
//			// namedQuery
//			repository.updateBy(50);

			Specification<Author> specification = Specification
					.where(AuthorSpecification.firstNameLike("Je"))
					.and(AuthorSpecification.hasAge(50));

			repository.findAll(specification)
					.forEach(System.out::println);

		};
	}
}
