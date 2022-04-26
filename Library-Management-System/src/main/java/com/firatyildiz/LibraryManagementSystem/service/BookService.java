package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.converter.BookConverter;
import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveBookRequestDto;
import com.firatyildiz.LibraryManagementSystem.entity.Book;
import com.firatyildiz.LibraryManagementSystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookConverter bookConverter;

    public String saveBook(SaveBookRequestDto saveBookRequestDto)
    {
        Book book = bookConverter.convertToBookFromSaveBookRequestDto(saveBookRequestDto);

        book = bookRepository.save(book);

        return book.getAuthor() + " Yazarına Ait " + book.getTitle() + " Kitabı Sisteme Başarıyla Eklendi.";
    }

}
