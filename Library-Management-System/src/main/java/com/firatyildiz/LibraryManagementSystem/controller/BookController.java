package com.firatyildiz.LibraryManagementSystem.controller;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveBookRequestDto;
import com.firatyildiz.LibraryManagementSystem.dto.requestDto.UpdateBookRequestDto;
import com.firatyildiz.LibraryManagementSystem.dto.responseDto.BookResponseDto;
import com.firatyildiz.LibraryManagementSystem.entity.Book;
import com.firatyildiz.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/saveBook")
    public ResponseEntity<String> saveBook(@RequestBody SaveBookRequestDto saveBookRequestDto)
    {
        String bookSaveDescription = bookService.saveBook(saveBookRequestDto);
        return new ResponseEntity<>(bookSaveDescription, HttpStatus.OK);
    }

    @GetMapping("/findAllBook")
    public ResponseEntity<List<BookResponseDto>> findAllBook()
    {
        List<BookResponseDto> bookResponseDtos = bookService.findAllBook();
        return new ResponseEntity<>(bookResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/findBookById")
    public ResponseEntity<Book> findBookById(@RequestParam Integer bookId)
    {
        Book book = bookService.findBook(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/updateBook")
    public ResponseEntity<String> updateBook(@RequestBody UpdateBookRequestDto updateBookRequestDto)
    {
        String updateBookDescription = bookService.updateBook(updateBookRequestDto);
        return new ResponseEntity<>(updateBookDescription, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBookById(@RequestParam Integer bookId)
    {
        String deleteBookDescription = bookService.deleteBookById(bookId);
        return new ResponseEntity<>(deleteBookDescription, HttpStatus.OK);
    }
}
