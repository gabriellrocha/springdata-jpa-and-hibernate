package com.gabrielcoding.jpa.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_seq"
    )
    @SequenceGenerator(
            name = "author_seq", // identificador lógico utilizado apenas pelo JPA
            sequenceName = "author_sequence", // nome da sequencia real no banco de dados
            initialValue = 2,
            allocationSize = 10

    )
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private Integer age;
}
