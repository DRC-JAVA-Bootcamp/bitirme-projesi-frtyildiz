package com.firatyildiz.LibraryManagementSystem.dto.responseDto;

import com.firatyildiz.LibraryManagementSystem.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponseDto {

    private int id;

    private String categoryName;

    private List<Book> books;

}
