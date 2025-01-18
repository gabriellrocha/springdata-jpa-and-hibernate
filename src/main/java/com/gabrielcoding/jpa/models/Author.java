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
            strategy = GenerationType.TABLE,
            generator = "author_id_generator"
    )
//  @SequenceGenerator(
//          name = "author_seq", // identificador lógico utilizado apenas pelo JPA
//          sequenceName = "author_sequence", // nome da sequencia real no banco de dados
//          initialValue = 2,
//          allocationSize = 10
//    )
    @TableGenerator(
            name = "author_id_generator",
            table = "id_generator",
            pkColumnName = "id_name",
            valueColumnName = "id_value",
            allocationSize = 1
    )
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private Integer age;
}
