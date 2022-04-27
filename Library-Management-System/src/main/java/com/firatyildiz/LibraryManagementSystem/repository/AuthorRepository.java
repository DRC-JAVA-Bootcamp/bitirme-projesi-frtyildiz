package com.firatyildiz.LibraryManagementSystem.repository;

import com.firatyildiz.LibraryManagementSystem.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
