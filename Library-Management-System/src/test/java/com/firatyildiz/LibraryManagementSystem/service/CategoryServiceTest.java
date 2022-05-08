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
        SaveCategoryRequestDto saveCategoryRequestDtoMock = mock(SaveCategoryRequestDto.class);
        saveCategoryRequestDtoMock.setCategoryName("testName");

        Category categoryMock = mock(Category.class);
        categoryMock.setId(1);

        when(modelMapper.map(saveCategoryRequestDtoMock, Category.class)).thenReturn(categoryMock);
        when(categoryRepository.save(categoryMock)).thenReturn(categoryMock);

        String saveCategory = categoryService.saveCategory(saveCategoryRequestDtoMock);
        String saveCategoryMessage = categoryMock.getCategoryName() + " Kategorisi Başarıyla Oluşturuldu.";

        assertEquals(saveCategory, saveCategoryMessage);
    }

    @Test
    void testFindCategory()
    {
        Category categoryMock = mock(Category.class);
        categoryMock.setId(1);

        when(categoryRepository.findById(categoryMock.getId())).thenReturn(Optional.of(categoryMock));
        Category findCategory = categoryService.findCategory(categoryMock.getId());

        assertEquals(categoryMock, findCategory);
    }

    @Test
    void testUpdateCategory()
    {
        Category categoryMock = mock(Category.class);
        categoryMock.setId(1);
        categoryMock.setCategoryName("testName");

        UpdateCategoryRequestDto updateCategoryRequestDtoMock = mock(UpdateCategoryRequestDto.class);
        updateCategoryRequestDtoMock.setCategoryName("updateTestName");

        when(categoryRepository.findById(categoryMock.getId())).thenReturn(Optional.of(categoryMock));

        String updateCategory = categoryService.updateCategory(updateCategoryRequestDtoMock);
        String updateCategoryMessage = "Değişiklik Başarıyla Gerçekleştirildi.";

        assertEquals(updateCategory, updateCategoryMessage);
    }

    @Test
    void testDeleteCategoryById()
    {
        Category categoryMock = mock(Category.class);
        categoryMock.setId(1);

        when(categoryRepository.findById(categoryMock.getId())).thenReturn(Optional.of(categoryMock));

        String deleteCategory = categoryService.deleteCategoryById(categoryMock.getId());
        String deleteCategoryMessage = "Silme İşlemi Başarıyla Gerçekleştirildi.";

        assertEquals(deleteCategory, deleteCategoryMessage);
    }
}