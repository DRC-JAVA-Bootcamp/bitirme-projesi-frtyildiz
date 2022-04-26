package com.firatyildiz.LibraryManagementSystem.controller;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveBookRequestDto;
import com.firatyildiz.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            "author":"John Fowles",
            "publisher":"Ayrıntı Yayınları",
            "language":"Türkçe",
            "page":688,
            "explanation":"Çağının yarı-entelektüel bunalımlarını geçirmekte olan, Oxford mezunu Nicholas Urfe, İngiltere’nin kasvetinden ve aşktan kaçmak için ücra bir Yunan adasına İngilizce öğretmeni olarak gider. Tek başına sıkıntılı günler geçirdiği, şair olduğuna dair hayallerinin de suya düştüğü bir sırada, gizemli milyoner Conchis ile tanışır...",
            "publicationDate":"2021-11-11",
            "format":"Ciltli"
         */
    }


}