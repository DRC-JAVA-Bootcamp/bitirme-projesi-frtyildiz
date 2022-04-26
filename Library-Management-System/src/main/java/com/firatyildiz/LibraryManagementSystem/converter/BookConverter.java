package com.firatyildiz.LibraryManagementSystem.converter;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveBookRequestDto;
import com.firatyildiz.LibraryManagementSystem.entity.Book;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookConverter {

    public Book convertToBookFromSaveBookRequestDto(SaveBookRequestDto saveBookRequestDto)
    {
        long isbnRequest = saveBookRequestDto.getIsbn();
        String titleRequest = saveBookRequestDto.getTitle();
        String authorRequest = saveBookRequestDto.getAuthor();
        String publisherRequest = saveBookRequestDto.getPublisher();
        String languageRequest = saveBookRequestDto.getLanguage();
        int pageRequest = saveBookRequestDto.getPage();
        String explanationRequest = saveBookRequestDto.getExplanation();
        LocalDate publicationDateRequest = saveBookRequestDto.getPublicationDate();
        String formatRequest = saveBookRequestDto.getFormat();

        Book book = new Book();

        book.setIsbn(isbnRequest);
        book.setTitle(titleRequest);
        book.setAuthor(authorRequest);
        book.setPublisher(publisherRequest);
        book.setLanguage(languageRequest);
        book.setPage(pageRequest);
        book.setExplanation(explanationRequest);
        book.setPublicationDate(publicationDateRequest);
        book.setFormat(formatRequest);

        return book;
    }
}
