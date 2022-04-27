package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveCategoryRequestDto;
import com.firatyildiz.LibraryManagementSystem.entity.Author;
import com.firatyildiz.LibraryManagementSystem.entity.Category;
import com.firatyildiz.LibraryManagementSystem.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    public String saveCategory(SaveCategoryRequestDto saveCategoryRequestDto) {
        Category category = modelMapper.map(saveCategoryRequestDto, Category.class);

        category = categoryRepository.save(category);

        return category.getCategoryName() + " Kategorisi Başarıyla Oluşturuldu.";
    }

    public Category findCategory(Integer categoryId)
    {
        return categoryRepository.findById(categoryId).get();
    }
}
