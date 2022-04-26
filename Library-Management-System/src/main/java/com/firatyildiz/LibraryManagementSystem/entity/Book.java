package com.firatyildiz.LibraryManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Book")
@Data
public class Book {

    // localhost:8098/h2-console

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ISBN")
    private long isbn;

    @Column(name = "Title")
    private String title;

    @Column(name = "Author")
    private String author;

    @Column(name = "Publisher")
    private String publisher;

    @Column(name = "Language")
    private String language;

    @Column(name = "Page")
    private int page;

    @Column(name = "Explanation")
    private String explanation;

    @Column(name = "PublicationDate")
    private LocalDate publicationDate;

    @Column(name = "Format")
    private String format;

}
