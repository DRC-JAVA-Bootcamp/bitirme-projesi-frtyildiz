package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveAuthorRequestDto;
import com.firatyildiz.LibraryManagementSystem.entity.Author;
import com.firatyildiz.LibraryManagementSystem.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @InjectMocks
    AuthorService authorService;

    @Mock
    AuthorRepository authorRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    void testFindAuthorById() {
        Author author = mock(Author.class);
        author.setId(1);

        when(authorRepository.findById(author.getId())).thenReturn(Optional.of(author));
        Author findAuthor = authorService.findAuthorById(author.getId());

        assertEquals(author, findAuthor);
    }

    @Test
    void testDeleteAuthorById() {
        Author author = mock(Author.class);
        author.setId(1);

        when(authorRepository.findById(author.getId())).thenReturn(Optional.of(author));
        String deleteAuthor = authorService.deleteAuthorById(author.getId());
        String deleteMessage = "Silme İşlemi Başarıyla Gerçekleştirildi.";

        assertEquals(deleteMessage, deleteAuthor);
    }

    @Test
    void testSaveAuthor()
    {
        SaveAuthorRequestDto saveAuthorRequestDto = mock(SaveAuthorRequestDto.class);
        saveAuthorRequestDto.setName("testName");
        saveAuthorRequestDto.setLastname("testLastname");

        Author author = mock(Author.class);
        author.setId(1);

        when(modelMapper.map(saveAuthorRequestDto, Author.class)).thenReturn(author);
        when(authorRepository.save(author)).thenReturn(author);
        String saveAuthor = authorService.saveAuthor(saveAuthorRequestDto);
        String saveAuthorMessage = author.getName() + " " + author.getLastname() + " İsimli Yazar Başarıyla Oluşturuldu.";

        assertEquals(saveAuthorMessage, saveAuthor);
    }



}