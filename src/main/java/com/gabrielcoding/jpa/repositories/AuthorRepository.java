package com.gabrielcoding.jpa.repositories;

import com.gabrielcoding.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // SELECT * FROM author WHERE first_name = 'gabriel';
    List<Author> findAllByFirstName(String firstName);

    // SELECT * FROM author WHERE first_name = 'gabriel';
    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    // SELECT * FROM author WHERE first_name LIKE '%biel%';
    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    // SELECT * FROM author WHERE first_name LIKE 'gab%';
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);

    // SELECT * FROM author WHERE first_name LIKE '%iel%'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String firstName);

    // SELECT * FROM author WHERE first_name in ('gabriel', 'coding')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
