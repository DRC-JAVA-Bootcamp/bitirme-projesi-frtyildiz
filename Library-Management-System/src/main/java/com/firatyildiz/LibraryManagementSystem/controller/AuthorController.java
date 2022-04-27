package com.firatyildiz.LibraryManagementSystem.controller;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveAuthorRequestDto;
import com.firatyildiz.LibraryManagementSystem.dto.requestDto.UpdateAuthorRequestDto;
import com.firatyildiz.LibraryManagementSystem.entity.Author;
import com.firatyildiz.LibraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/saveAuthor")
    public ResponseEntity<String> saveAuthor(@RequestBody SaveAuthorRequestDto saveAuthorRequestDto)
    {
        String authorSaveDescription = authorService.saveAuthor(saveAuthorRequestDto);
        return new ResponseEntity<>(authorSaveDescription, HttpStatus.OK);

        /*
            "name":"John",
            "lastname":"Fowles"
         */
    }

    @GetMapping("/findAuthorById")
    public ResponseEntity<Author> findAuthorById(@RequestParam Integer authorId)
    {
        Author author = authorService.findAuthor(authorId);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping("/updateAuthor")
    public ResponseEntity<String> updateAuthor(@RequestBody UpdateAuthorRequestDto updateAuthorRequestDto)
    {
        String updateAuthorDescription = authorService.updateAuthor(updateAuthorRequestDto);
        return new ResponseEntity<>(updateAuthorDescription, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAuthor")
    public ResponseEntity<String> deleteAuthorById(@RequestParam Integer authorId)
    {
        String deleteAuthorDescription = authorService.deleteAuthorById(authorId);
        return new ResponseEntity<>(deleteAuthorDescription, HttpStatus.OK);
    }


}
