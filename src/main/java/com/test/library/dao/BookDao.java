package com.test.library.dao;

import com.test.library.model.Book;
import org.hibernate.Query;

import java.util.List;

public interface BookDao {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void removeBook(int id);

    public Book getBookById(int id);

    public List<Book> listBooks();

    public List<Book> searchBookByAuthor(String bookAuthor);

    public List<Book> searchBookByTitle(String bookTitle);
}
