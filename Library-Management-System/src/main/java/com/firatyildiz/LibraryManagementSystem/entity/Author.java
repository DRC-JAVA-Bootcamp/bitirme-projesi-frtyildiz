package com.firatyildiz.LibraryManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "Lastname", length = 50)
    private String lastname;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

}
