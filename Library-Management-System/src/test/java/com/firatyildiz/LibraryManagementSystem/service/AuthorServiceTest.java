package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.repository.AuthorRepository;
import com.firatyildiz.LibraryManagementSystem.validation.AuthorServiceValidation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @InjectMocks
    AuthorServiceValidation authorServiceValidation;

    @Mock
    AuthorService authorService;

    @Mock
    AuthorRepository authorRepository;

    @Mock
    ModelMapper modelMapper;




}