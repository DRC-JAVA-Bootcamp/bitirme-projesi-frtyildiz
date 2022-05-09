package com.firatyildiz.LibraryManagementSystem.dto.responseDto;

import lombok.Data;

@Data
public class AuthorResponseDto {

    private int id;

    private String name;

    private String lastname;

    private int bookId;
}
