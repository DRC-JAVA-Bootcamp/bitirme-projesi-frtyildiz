package com.firatyildiz.LibraryManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ISBN")
    private long isbn;

    @Column(name = "Title", length = 75)
    private String title;

    @Column(name = "Publisher", length = 75)
    private String publisher;

    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne
    @JoinColumn
    private Category category;

    @Column(name = "Language", length = 25)
    private String language;

    @Column(name = "Page")
    private int page;

    @Column(name = "Explanation", length = 1000)
    private String description;

    @Column(name = "PublicationDate")
    private LocalDate publicationDate;

    @Column(name = "Format", length = 25)
    private String format;
}
