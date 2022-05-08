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
        Book book = mock(Book.class);
        book.setId(1);

        when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        Book findBook = bookService.findBook(book.getId());

        assertEquals(book, findBook);
    }

    @Test
    void testDeleteBookById()
    {
        Book book = mock(Book.class);
        book.setId(1);

        when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        String deleteBook = bookService.deleteBookById(book.getId());
        String deleteBookMessage = "Silme İşlemi Başarıyla Gerçekleştirildi.";

        assertEquals(deleteBook, deleteBookMessage);
    }

    /*
    @Test
    void testUpdateBook()
    {
        Book book = mock(Book.class);
        book.setId(1);
        book.setPage(734);
        book.setTitle("testTitle");

        UpdateBookRequestDto updateBookRequestDto = mock(UpdateBookRequestDto.class);
        updateBookRequestDto.setId(1);
        updateBookRequestDto.setTitle("updateTestTitle");

        when(bookRepository.findById(any())).thenReturn(Optional.of(book));
        String updateBook = bookService.updateBook(updateBookRequestDto);
        String updateBookMessage = "Değişiklikler Başarıyla Gerçekleştirildi.";

        assertEquals(updateBook, updateBookMessage);
    }
     */

    @Test
    void testSaveBook()
    {
    }
}