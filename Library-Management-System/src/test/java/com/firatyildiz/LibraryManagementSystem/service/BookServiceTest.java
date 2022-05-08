package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.entity.Book;
import com.firatyildiz.LibraryManagementSystem.repository.BookRepository;
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
class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Mock
    ModelMapper modelMapper;

    @Mock
    AuthorService authorService;

    @Mock
    CategoryService categoryService;

    @Test
    void testFindBook()
    {
        Book book = mock(Book.class);
        book.setId(1);

        when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        Book findBook = bookService.findBook(book.getId());

        assertEquals(book, findBook);
    }

    @Test
    void testUpdateBook()
    {
    }

    @Test
    void testDeleteBookById()
    {
    }

    @Test
    void testSaveBook()
    {
    }
}