package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveAuthorRequestDto;
import com.firatyildiz.LibraryManagementSystem.dto.requestDto.UpdateAuthorRequestDto;
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
    void testFindAuthorById()
    {
        Author authorMock = mock(Author.class);
        authorMock.setId(1);

        when(authorRepository.findById(authorMock.getId())).thenReturn(Optional.of(authorMock));
        Author findAuthor = authorService.findAuthorById(authorMock.getId());

        assertEquals(authorMock, findAuthor);
    }

    @Test
    void testDeleteAuthorById()
    {
        Author authorMock = mock(Author.class);
        authorMock.setId(1);

        when(authorRepository.findById(authorMock.getId())).thenReturn(Optional.of(authorMock));
        String deleteAuthor = authorService.deleteAuthorById(authorMock.getId());
        String deleteMessage = "The Author Deleted.";

        assertEquals(deleteMessage, deleteAuthor);
    }

    @Test
    void testSaveAuthor()
    {
        SaveAuthorRequestDto saveAuthorRequestDtoMock = mock(SaveAuthorRequestDto.class);
        saveAuthorRequestDtoMock.setName("testName");
        saveAuthorRequestDtoMock.setLastname("testLastname");

        Author authorMock = mock(Author.class);
        authorMock.setId(1);

        when(modelMapper.map(saveAuthorRequestDtoMock, Author.class)).thenReturn(authorMock);
        when(authorRepository.save(authorMock)).thenReturn(authorMock);
        String saveAuthor = authorService.saveAuthor(saveAuthorRequestDtoMock);
        String saveAuthorMessage = authorMock.getName() + " " + authorMock.getLastname() + " Has Been Created Successfully.";

        assertEquals(saveAuthorMessage, saveAuthor);
    }

    @Test
    void testUpdateAuthor()
    {
        Author authorMock = mock(Author.class);
        authorMock.setId(1);
        authorMock.setName("testName");
        authorMock.setLastname("testLastname");

        UpdateAuthorRequestDto updateAuthorRequestDtoMock = mock(UpdateAuthorRequestDto.class);
        updateAuthorRequestDtoMock.setName("updateTestName");
        updateAuthorRequestDtoMock.setLastname("updateTestLastname");

        when(authorRepository.findById(authorMock.getId())).thenReturn(Optional.of(authorMock));

        String updateAuthor = authorService.updateAuthor(updateAuthorRequestDtoMock);
        String updateAuthorMessage = "Changes Saved Successfully.";

        assertEquals(updateAuthorMessage, updateAuthor);
    }

}