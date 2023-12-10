package com.project.bookstore.repository;


import com.project.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, String> {

    @Transactional
    void deleteByIsbn(String isbn);

    Optional<Book> getByIsbn(String isbn);

   @Query(value = "SELECT * FROM book b where b.title =:title and :author = any(authors) ", nativeQuery = true)
   List<Book> findBooksByTitleAndAuthor(String title,String author);
}