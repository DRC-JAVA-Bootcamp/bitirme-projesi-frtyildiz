package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveBookRequestDto;
import com.firatyildiz.LibraryManagementSystem.entity.Book;
import com.firatyildiz.LibraryManagementSystem.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ModelMapper modelMapper;

    public String saveBook(SaveBookRequestDto saveBookRequestDto)
    {
        Book book = modelMapper.map(saveBookRequestDto, Book.class);

        book = bookRepository.save(book);

        return book.getAuthor() + " Yazarına Ait " + book.getTitle() + " Kitabı Sisteme Başarıyla Eklendi.";
    }

}
