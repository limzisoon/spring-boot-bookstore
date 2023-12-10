package com.project.bookstore.repository;


import com.project.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, String> {

}