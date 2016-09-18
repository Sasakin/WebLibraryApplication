package com.test.library.service;

import com.test.library.model.Book;
import org.hibernate.Query;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void removeBook(int id);

    public Book getBookById(int id);

    public List<Book> listBooks();

    public List<Book> searchBooksByAuthor(String bookAuthor);

    public List<Book> searchBooksByTitle(String bookTitle);
}
