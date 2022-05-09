package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveBookRequestDto;
import com.firatyildiz.LibraryManagementSystem.dto.requestDto.UpdateBookRequestDto;
import com.firatyildiz.LibraryManagementSystem.dto.responseDto.BookResponseDto;
import com.firatyildiz.LibraryManagementSystem.entity.Author;
import com.firatyildiz.LibraryManagementSystem.entity.Book;
import com.firatyildiz.LibraryManagementSystem.entity.Category;
import com.firatyildiz.LibraryManagementSystem.repository.AuthorRepository;
import com.firatyildiz.LibraryManagementSystem.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Autowired
    AuthorRepository authorRepository;

    public String saveBook(SaveBookRequestDto saveBookRequestDto) {
        long isbnRequest = saveBookRequestDto.getIsbn();
        String titleRequest = saveBookRequestDto.getTitle();
        int authorIdRequest = saveBookRequestDto.getAuthorId();
        String publisherRequest = saveBookRequestDto.getPublisher();
        String languageRequest = saveBookRequestDto.getLanguage();
        int pageRequest = saveBookRequestDto.getPage();
        String descriptionRequest = saveBookRequestDto.getDescription();
        LocalDate publicationDateRequest = saveBookRequestDto.getPublicationDate();
        String formatRequest = saveBookRequestDto.getFormat();
        int categoryIdRequest = saveBookRequestDto.getCategoryId();

        Category category = categoryService.findCategory(categoryIdRequest);
        Author author = authorRepository.findById(authorIdRequest).get();

        Book book = new Book();

        book.setIsbn(isbnRequest);
        book.setTitle(titleRequest);
        book.setAuthor(author);
        book.setPublisher(publisherRequest);
        book.setLanguage(languageRequest);
        book.setPage(pageRequest);
        book.setDescription(descriptionRequest);
        book.setPublicationDate(publicationDateRequest);
        book.setFormat(formatRequest);
        book.setCategory(category);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        category.setBooks(bookList);
        author.setBooks(bookList);

        bookRepository.save(book);

        return book.getTitle() + " Kitabı Sisteme Başarıyla Eklendi.";
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

    public String updateBook(UpdateBookRequestDto updateBookRequestDto)
    {

        long isbnRequest = updateBookRequestDto.getIsbn();
        String titleRequest = updateBookRequestDto.getTitle();
        int authorIdRequest = updateBookRequestDto.getAuthorId();
        String publisherRequest = updateBookRequestDto.getPublisher();
        String languageRequest = updateBookRequestDto.getLanguage();
        int pageRequest = updateBookRequestDto.getPage();
        String descriptionRequest = updateBookRequestDto.getDescription();
        LocalDate publicationDateRequest = updateBookRequestDto.getPublicationDate();
        String formatRequest = updateBookRequestDto.getFormat();
        int categoryIdRequest = updateBookRequestDto.getCategoryId();

        Category category = categoryService.findCategory(categoryIdRequest);
        Author author = authorRepository.findById(authorIdRequest).get();

        Book book = new Book();

        book.setIsbn(isbnRequest);
        book.setTitle(titleRequest);
        book.setAuthor(author);
        book.setPublisher(publisherRequest);
        book.setLanguage(languageRequest);
        book.setPage(pageRequest);
        book.setDescription(descriptionRequest);
        book.setPublicationDate(publicationDateRequest);
        book.setFormat(formatRequest);
        book.setCategory(category);

        bookRepository.save(book);

        return "Değişiklikler Başarıyla Gerçekleştirildi.";
    }

    public String deleteBookById(Integer bookId)
    {
        Book book = bookRepository.findById(bookId).get();
        bookRepository.delete(book);
        return "Silme İşlemi Başarıyla Gerçekleştirildi.";
    }
}
