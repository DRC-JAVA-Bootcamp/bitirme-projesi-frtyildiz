package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveBookRequestDto;
import com.firatyildiz.LibraryManagementSystem.dto.responseDto.BookResponseDto;
import com.firatyildiz.LibraryManagementSystem.entity.Author;
import com.firatyildiz.LibraryManagementSystem.entity.Book;
import com.firatyildiz.LibraryManagementSystem.entity.Category;
import com.firatyildiz.LibraryManagementSystem.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AuthorService authorService;

    @Autowired
    CategoryService categoryService;


    public String saveBook(SaveBookRequestDto saveBookRequestDto) {
        Book book = modelMapper.map(saveBookRequestDto, Book.class);
        List<Author> authors = new ArrayList();
        for (Integer authorId : saveBookRequestDto.getAuthorId()) {
            Author author = authorService.findAuthor(authorId);
            authors.add(author);
        }
        book.setAuthors(authors);

        Category category = categoryService.findCategory(saveBookRequestDto.getCategoryId());
        book.setCategory(category);
        book = bookRepository.save(book);

        return book.getTitle() + " Kitabı Sisteme Başarıyla Eklendi.";
//        return book.getAuthor() + " Yazarına Ait " + book.getTitle() + " Kitabı Sisteme Başarıyla Eklendi.";
    }

    public List<BookResponseDto> findAllBook() {
        Iterable<Book> books = bookRepository.findAll();

        List<BookResponseDto> bookResponseDtos = new ArrayList<>();

        for (Book book : books) {
            BookResponseDto bookResponseDto = modelMapper.map(book, BookResponseDto.class);
            bookResponseDtos.add(bookResponseDto);
        }

        return bookResponseDtos;
    }

    public Book findBook(Integer bookId) {
        return bookRepository.findById(bookId).get();
    }


}
