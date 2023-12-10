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

    /**
     * This method create book.
     *
     * @param book
     */
    public Optional<Book> createBook(Book book) throws Exception
    {
        System.out.println("createBook : " + book.toString());
        bookRepository.save(book);

        Optional<Book> bookDb = getBook(book.getIsbn());

        return bookDb;
    }

    /**
     * This method get book by isbn
     *
     * @param isbn
     */
    public Optional<Book> getBook(String isbn) throws Exception
    {
        System.out.println("getBook : " + isbn);
        return bookRepository.getByIsbn(isbn);
    }

    /**
     * This method update book information
     *
     * @param book
     */
    public Optional<Book> updateBook(Book book) throws Exception
    {
        bookRepository.save(book);

        Optional<Book> bookDb = getBook(book.getIsbn());

        return bookDb;
    }

    /**
     * This method delete book by isbn
     *
     * @param isbn
     */
    public void deleteBook(String isbn) throws Exception
    {
        bookRepository.deleteByIsbn(isbn);
    }

    /**
     * This method find books by Title And Author
     *
     * @param bookRequestDTO
     */
    public List<Book> findBooksByTitleAndAuthor(BookRequestDTO bookRequestDTO) throws Exception
    {
        System.out.println("bookRequestDTO.getTitle() : " + bookRequestDTO.getTitle());
        System.out.println("bookRequestDTO.getAuthor() : " + bookRequestDTO.getAuthor());
        return bookRepository.findBooksByTitleAndAuthor(bookRequestDTO.getTitle(),bookRequestDTO.getAuthor());
    }

    /**
     * This method find all books
     *
     */
    public List<Book> findBooks() throws Exception
    {
        return bookRepository.findAll();
    }
}
