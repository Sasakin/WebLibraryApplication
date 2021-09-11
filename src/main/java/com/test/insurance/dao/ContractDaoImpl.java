package com.test.insurance.dao;

import com.test.insurance.model.Contract;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository("contractDao")
public class ContractDaoImpl implements ContractDao {
    private static final Logger logger = LoggerFactory.getLogger(ContractDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addContract(Contract contract) {
       Session session = this.sessionFactory.getCurrentSession();
       session.persist(contract);
       logger.info("Contract successfully saved. Contract details: " + contract);
    }

    @Override
    public void updateContract(Contract contract) {
        //Session session = this.sessionFactory.getCurrentSession();
      //  session.update(book);
        logger.info("Book successfully update. Book details: " + contract);
    }

    @Override
    public void removeContract(int id) {
        //Session session = this.sessionFactory.getCurrentSession();
       // Book book = (Book) session.load(Book.class, new Integer(id));

        //if(book!=null){
       //     session.delete(book);
       // }
       // logger.info("Book successfully removed. Book details: " + book);
    }

    @Override
    public Contract getContractById(int id) {
        Contract contract = entityManager.unwrap(Session.class).load(Contract.class, new Integer(id));
        return contract;
    }

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @SuppressWarnings("unchecked")
    public List<Contract> listContracts() {
        List<Contract> list = entityManager.unwrap(Session.class).createQuery("from Contract").getResultList();
        return list;
    }

   /* @Override
    public List<Book> searchContractByAuthor(String bookAuthor) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT book FROM Book book  WHERE book.bookAuthor =:bookAuthor" );
        query.setParameter("bookAuthor", bookAuthor );
        List<Book> bookList = (List<Book>) query.list();
        return bookList;
        return new ArrayList<Book>();
    }*/

}
