package com.firatyildiz.LibraryManagementSystem.dto.responseDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookResponseDto {

    private long isbn;

    private String title;

//    private String author;

    private String publisher;

    private String language;

    private int page;

    private String explanation;

    private LocalDate publicationDate;

    private String format;

}