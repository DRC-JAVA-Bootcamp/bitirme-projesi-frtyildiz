package com.firatyildiz.LibraryManagementSystem.service;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveCategoryRequestDto;
import com.firatyildiz.LibraryManagementSystem.dto.requestDto.UpdateCategoryRequestDto;
import com.firatyildiz.LibraryManagementSystem.entity.Category;
import com.firatyildiz.LibraryManagementSystem.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @InjectMocks
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    void testSaveCategory()
    {
        SaveCategoryRequestDto saveCategoryRequestDto = mock(SaveCategoryRequestDto.class);
        saveCategoryRequestDto.setCategoryName("testName");

        Category category = mock(Category.class);
        category.setId(1);

        when(modelMapper.map(saveCategoryRequestDto, Category.class)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(category);

        String saveCategory = categoryService.saveCategory(saveCategoryRequestDto);
        String saveCategoryMessage = category.getCategoryName() + " Kategorisi Başarıyla Oluşturuldu.";

        assertEquals(saveCategory, saveCategoryMessage);
    }

    @Test
    void testFindCategory()
    {
        Category category = mock(Category.class);
        category.setId(1);

        when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));
        Category findCategory = categoryService.findCategory(category.getId());

        assertEquals(category, findCategory);
    }

    @Test
    void testUpdateCategory()
    {
        Category category = mock(Category.class);
        category.setId(1);
        category.setCategoryName("testName");

        UpdateCategoryRequestDto updateCategoryRequestDto = mock(UpdateCategoryRequestDto.class);
        updateCategoryRequestDto.setCategoryName("updateTestName");

        when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));

        String updateCategory = categoryService.updateCategory(updateCategoryRequestDto);
        String updateCategoryMessage = "Değişiklik Başarıyla Gerçekleştirildi.";

        assertEquals(updateCategory, updateCategoryMessage);
    }

    @Test
    void testDeleteCategoryById()
    {
        Category category = mock(Category.class);
        category.setId(1);

        when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));

        String deleteCategory = categoryService.deleteCategoryById(category.getId());
        String deleteCategoryMessage = "Silme İşlemi Başarıyla Gerçekleştirildi.";

        assertEquals(deleteCategory, deleteCategoryMessage);
    }
}