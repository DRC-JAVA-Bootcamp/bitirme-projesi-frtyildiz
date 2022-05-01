package com.firatyildiz.LibraryManagementSystem.dto.responseDto;

import com.firatyildiz.LibraryManagementSystem.entity.Author;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookResponseDto {

    private long isbn;

    private String title;

    private int authorId;

    private String publisher;

    private String language;

    private int page;

    private String explanation;

    private LocalDate publicationDate;

    private String format;

    private int categoryId;

}
