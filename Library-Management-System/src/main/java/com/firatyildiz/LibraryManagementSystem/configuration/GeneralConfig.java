package com.firatyildiz.LibraryManagementSystem.configuration;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveBookRequestDto;
import com.firatyildiz.LibraryManagementSystem.entity.Author;
import com.firatyildiz.LibraryManagementSystem.entity.Book;
import com.firatyildiz.LibraryManagementSystem.entity.Category;
import com.firatyildiz.LibraryManagementSystem.repository.AuthorRepository;
import com.firatyildiz.LibraryManagementSystem.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class GeneralConfig {


    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }



}
