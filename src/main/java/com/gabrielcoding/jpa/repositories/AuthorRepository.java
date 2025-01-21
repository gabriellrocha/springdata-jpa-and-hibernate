package com.gabrielcoding.jpa.repositories;

import com.gabrielcoding.jpa.models.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {


    List<Author> findBy(@Param("age") int age);

    @Modifying
    @Transactional
    void updateBy(@Param("age") int age);


    // UPDATE author a set a.age = 50 where a.id = id = 1;
    @Modifying
    @Transactional
    @Query("UPDATE Author a SET a.age = :age WHERE a.id = :id")
    int updateAuthor(@Param("age") int age, @Param("id") int id);

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
