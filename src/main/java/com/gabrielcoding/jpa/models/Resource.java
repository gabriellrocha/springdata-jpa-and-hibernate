package com.gabrielcoding.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "resource_type", length = 10) only with strategy SINGLE TABLE
public class Resource {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer size;

    private String url;

    @OneToOne
    private Lecture lecture;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime lastModifiedAt;

    private String createdBy;

    private String lastModifiedBy;
}
