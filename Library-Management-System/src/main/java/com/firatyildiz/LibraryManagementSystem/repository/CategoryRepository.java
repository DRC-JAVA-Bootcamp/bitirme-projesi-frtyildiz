package com.firatyildiz.LibraryManagementSystem.repository;

import com.firatyildiz.LibraryManagementSystem.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
