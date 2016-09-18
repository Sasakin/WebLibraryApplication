package com.test.library.dao;

import com.test.library.model.Book;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Repository
public class BookDaoImpl implements BookDao {
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book successfully saved. Book details: " + book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book successfully update. Book details: " + book);
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));

        if(book!=null){
            session.delete(book);
        }
        logger.info("Book successfully removed. Book details: " + book);
    }

    @Override
    public Book getBookById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        logger.info("Book successfully loaded. Book details: " + book);

        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();

        for(Book book: bookList){
            logger.info("Book list: " + book);
        }

        return bookList;
    }

    @Override
    public List<Book> searchBookByAuthor(String bookAuthor) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT book FROM Book book  WHERE book.bookAuthor =:bookAuthor" );
        query.setParameter("bookAuthor", bookAuthor );
        List<Book> bookList = (List<Book>) query.list();
        return bookList;
    }

    @Override
    public List<Book> searchBookByTitle(String bookTitle) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT book FROM Book book  WHERE book.bookTitle =:bookTitle" );
        query.setParameter("bookTitle", bookTitle );
        List<Book> bookList = (List<Book>) query.list();
        return bookList;
    }

}
