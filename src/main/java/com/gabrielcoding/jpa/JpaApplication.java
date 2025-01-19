package com.gabrielcoding.jpa;

import com.gabrielcoding.jpa.models.Author;
import com.gabrielcoding.jpa.models.Video;
import com.gabrielcoding.jpa.repositories.AuthorRepository;
import com.gabrielcoding.jpa.repositories.VideoRepository;
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
			VideoRepository videoRepository
	){
		return args -> {

			var video = Video.builder()
					.url("http://www.video.com")
					.name("Learn Spring Data JPA and Hibernate")
					.build();

			videoRepository.save(video);
		};
	}
}
