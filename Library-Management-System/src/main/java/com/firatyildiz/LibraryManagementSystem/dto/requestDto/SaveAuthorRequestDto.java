package com.firatyildiz.LibraryManagementSystem.dto.requestDto;

import com.firatyildiz.LibraryManagementSystem.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class SaveAuthorRequestDto {

    private String name;

    private String lastname;

    private List<Book> books;
}
