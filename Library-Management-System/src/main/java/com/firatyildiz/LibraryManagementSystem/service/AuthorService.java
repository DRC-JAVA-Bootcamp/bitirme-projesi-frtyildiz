package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveAuthorRequestDto;
import com.firatyildiz.LibraryManagementSystem.dto.requestDto.UpdateAuthorRequestDto;
import com.firatyildiz.LibraryManagementSystem.dto.responseDto.AuthorResponseDto;
import com.firatyildiz.LibraryManagementSystem.entity.Author;
import com.firatyildiz.LibraryManagementSystem.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public String updateAuthor(UpdateAuthorRequestDto updateAuthorRequestDto)
    {
        int idAuthorRequest = updateAuthorRequestDto.getId();
        String nameAuthorRequest = updateAuthorRequestDto.getName();
        String lastnameAuthorRequest = updateAuthorRequestDto.getLastname();

        Optional<Author> authorOptional = authorRepository.findById(idAuthorRequest);
        Author author = authorOptional.get();

        author.setName(lastnameAuthorRequest);
        author.setName(nameAuthorRequest);

        authorRepository.save(author);

        return "Değişiklikler Başarıyla Gerçekleştirildi.";
    }

    public String deleteAuthorById(Integer authorId)
    {
        Author author = authorRepository.findById(authorId).get();
        authorRepository.delete(author);
        return "Silme İşlemi Başarıyla Gerçekleştirildi.";
    }

    public List<AuthorResponseDto> findAllAuthor()
    {
        Iterable<Author> authors = authorRepository.findAll();

        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();

        for (Author author : authors) {
            AuthorResponseDto authorResponseDto = modelMapper.map(author, AuthorResponseDto.class);
            authorResponseDtos.add(authorResponseDto);
        }

        return authorResponseDtos;
    }
}
