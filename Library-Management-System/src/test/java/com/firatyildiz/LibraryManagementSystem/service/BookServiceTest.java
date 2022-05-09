package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.UpdateBookRequestDto;
import com.firatyildiz.LibraryManagementSystem.entity.Author;
import com.firatyildiz.LibraryManagementSystem.entity.Book;
import com.firatyildiz.LibraryManagementSystem.entity.Category;
import com.firatyildiz.LibraryManagementSystem.repository.AuthorRepository;
import com.firatyildiz.LibraryManagementSystem.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
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

    @Mock
    AuthorRepository authorRepository;

    @Test
    void testFindBook()
    {
        Book bookMock = mock(Book.class);
        bookMock.setId(1);

        when(bookRepository.findById(bookMock.getId())).thenReturn(Optional.of(bookMock));
        Book findBook = bookService.findBook(bookMock.getId());

        assertEquals(bookMock, findBook);
    }

    @Test
    void testDeleteBookById()
    {
        Book bookMock = mock(Book.class);
        bookMock.setId(1);

        when(bookRepository.findById(bookMock.getId())).thenReturn(Optional.of(bookMock));
        String deleteBook = bookService.deleteBookById(bookMock.getId());
        String deleteBookMessage = "The Book Deleted.";

        assertEquals(deleteBook, deleteBookMessage);
    }

    /*
    @Test
    void testUpdateBook()
    {
        Book bookMock = mock(Book.class);
        bookMock.setId(1);
        bookMock.setPage(734);
        bookMock.setTitle("testTitle");

        UpdateBookRequestDto updateBookRequestDtoMock = mock(UpdateBookRequestDto.class);
        updateBookRequestDtoMock.setId(1);
        updateBookRequestDtoMock.setTitle("updateTestTitle");

        when(bookRepository.findById(any())).thenReturn(Optional.of(bookMock));
        String updateBook = bookService.updateBook(updateBookRequestDtoMock);
        String updateBookMessage = "Değişiklikler Başarıyla Gerçekleştirildi.";

        assertEquals(updateBook, updateBookMessage);
    }
     */


    @Test
    void testSaveBook()
    {
    }
}