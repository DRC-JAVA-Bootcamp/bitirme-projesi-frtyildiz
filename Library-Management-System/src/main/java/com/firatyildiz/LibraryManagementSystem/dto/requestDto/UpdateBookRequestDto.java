package com.firatyildiz.LibraryManagementSystem.dto.requestDto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UpdateBookRequestDto {

    private long isbn;

    private String title;

    private List<Integer> authorId;

    private String publisher;

    private String language;

    private int page;

    private String explanation;

    private LocalDate publicationDate;

    private String format;

    private int categoryId;

}