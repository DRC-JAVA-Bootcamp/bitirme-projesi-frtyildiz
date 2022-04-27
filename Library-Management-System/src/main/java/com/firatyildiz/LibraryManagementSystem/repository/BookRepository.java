package com.firatyildiz.LibraryManagementSystem.repository;

import com.firatyildiz.LibraryManagementSystem.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {


}
