package com.gabrielcoding.jpa.repositories;

import com.gabrielcoding.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
