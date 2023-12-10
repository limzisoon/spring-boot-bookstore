package com.project.bookstore.service;

import com.project.bookstore.entity.Book;
import com.project.bookstore.payload.request.BookRequestDTO;
import com.project.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Optional<Book> createBook(Book book) throws Exception
    {
        System.out.println("createBook : " + book.toString());
        bookRepository.save(book);

        Optional<Book> bookDb = getBook(book.getIsbn());

        return bookDb;
    }

    public Optional<Book> getBook(String isbn) throws Exception
    {
        System.out.println("getBook : " + isbn);
        return bookRepository.getByIsbn(isbn);
    }

    public Optional<Book> updateBook(Book book) throws Exception
    {
        bookRepository.save(book);

        Optional<Book> bookDb = getBook(book.getIsbn());

        return bookDb;
    }

    public void deleteBook(String isbn) throws Exception
    {
        bookRepository.deleteByIsbn(isbn);
    }

    public List<Book> findBooksByTitleAndAuthor(BookRequestDTO bookRequestDTO) throws Exception
    {
        System.out.println("bookRequestDTO.getTitle() : " + bookRequestDTO.getTitle());
        System.out.println("bookRequestDTO.getAuthor() : " + bookRequestDTO.getAuthor());
        return bookRepository.findBooksByTitleAndAuthor(bookRequestDTO.getTitle(),bookRequestDTO.getAuthor());
    }

    public List<Book> findBooks() throws Exception
    {
        return bookRepository.findAll();
    }
}
