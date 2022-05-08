package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.entity.Author;
import com.firatyildiz.LibraryManagementSystem.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @InjectMocks
    AuthorService authorService;

    @Mock
    AuthorRepository authorRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    void findAuthorById() {
        Author author = mock(Author.class);
        author.setId(1);
        author.setName("Test");
        author.setLastname("Test");

        when(authorRepository.findById(author.getId())).thenReturn(Optional.of(author));
        Author deleteAuthor = authorService.findAuthorById(author.getId());

        assertEquals(author, deleteAuthor);
    }

    @Test
    void deleteAuthorById() {
    }
}