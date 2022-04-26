package com.firatyildiz.LibraryManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "categoryName")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;


}
