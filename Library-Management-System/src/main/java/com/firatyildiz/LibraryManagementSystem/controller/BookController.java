package com.firatyildiz.LibraryManagementSystem.controller;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveBookRequestDto;
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

        /*
            "isbn":9789755393735,
            "title":"Büyücü",
            "authorId":[2],
            "publisher":"Ayrıntı Yayınları",
            "language":"Türkçe",
            "page":688,
            "explanation":"Çağının yarı-entelektüel bunalımlarını geçirmekte olan, Oxford mezunu Nicholas Urfe, İngiltere’nin kasvetinden ve aşktan kaçmak için ücra bir Yunan adasına İngilizce öğretmeni olarak gider. Tek başına sıkıntılı günler geçirdiği, şair olduğuna dair hayallerinin de suya düştüğü bir sırada, gizemli milyoner Conchis ile tanışır...",
            "publicationDate":"2021-11-11",
            "format":"Ciltli",
            "categoryId":1
         */
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



}
