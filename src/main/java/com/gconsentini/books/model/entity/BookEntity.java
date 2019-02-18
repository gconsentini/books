package com.gconsentini.books.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column
    private String isbn;
    @Column
    private String language;

}
