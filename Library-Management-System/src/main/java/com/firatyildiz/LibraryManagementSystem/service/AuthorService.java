package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveAuthorRequestDto;
import com.firatyildiz.LibraryManagementSystem.entity.Author;
import com.firatyildiz.LibraryManagementSystem.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    ModelMapper modelMapper;


    public String saveAuthor(SaveAuthorRequestDto saveAuthorRequestDto)
    {
        Author author = modelMapper.map(saveAuthorRequestDto, Author.class);

        author = authorRepository.save(author);

        return author.getName() + " " + author.getLastname() + " İsimli Yazar Başarıyla Oluşturuldu.";
    }

    public Author findAuthor(Integer authorId)
    {
        return authorRepository.findById(authorId).get();
    }

    /*
    public String saveAuthorToBookByIds(int bookId, int authorId) {

        Book book = new Book();
        Author author = new Author();

        Author authorRequest = author.getId(authorId);
    }

     */
}
