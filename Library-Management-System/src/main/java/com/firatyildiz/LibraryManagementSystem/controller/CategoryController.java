package com.firatyildiz.LibraryManagementSystem.controller;

import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveAuthorRequestDto;
import com.firatyildiz.LibraryManagementSystem.dto.requestDto.SaveCategoryRequestDto;
import com.firatyildiz.LibraryManagementSystem.entity.Author;
import com.firatyildiz.LibraryManagementSystem.entity.Category;
import com.firatyildiz.LibraryManagementSystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/saveCategory")
    public ResponseEntity<String> saveCategory(@RequestBody SaveCategoryRequestDto saveCategoryRequestDto)
    {
        String categorySaveDescription = categoryService.saveCategory(saveCategoryRequestDto);
        return new ResponseEntity<>(categorySaveDescription, HttpStatus.OK);

        /*
            "categoryName":"Modern Klasikler",
         */
    }

    @GetMapping("/findCategoryById")
    public ResponseEntity<Category> findCategoryById(@RequestParam Integer categoryId)
    {
        Category category = categoryService.findCategory(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
