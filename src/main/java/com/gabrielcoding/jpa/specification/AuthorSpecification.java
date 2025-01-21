package com.gabrielcoding.jpa.specification;

import com.gabrielcoding.jpa.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

public class AuthorSpecification {

    // Usada p/ definir filtros

    public static Specification<Author> hasAge(int age) {

        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {

            if (age < 1) {
                return null;
            }
            return builder.equal(root.get("age"), age);
        };
    }

    public static Specification<Author> firstNameLike(String firstName) {

        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {

            if(firstName == null) {
                return null;
            }
            return builder.like(root.get("firstName"), "%"+firstName+"%");
        };
    }
}
