package com.firatyildiz.LibraryManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "Title", length = 75)
    private String title;

    @Column(name = "Publisher", length = 75)
    private String publisher;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "bookAuthor", joinColumns = @JoinColumn(name = "book_id"))
    private List<Author> authors = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "Language", length = 25)
    private String language;

    @Column(name = "Page")
    private int page;

    @Column(name = "Explanation", length = 1000)
    private String explanation;

    @Column(name = "PublicationDate")
    private LocalDate publicationDate;

    @Column(name = "Format", length = 25)
    private String format;

}
