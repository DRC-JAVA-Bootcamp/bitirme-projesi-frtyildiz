package com.firatyildiz.LibraryManagementSystem.dto.responseDto;

import com.firatyildiz.LibraryManagementSystem.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class AuthorResponseDto {

    private int id;

    private String name;

    private String lastname;

    private int bookId;
}
