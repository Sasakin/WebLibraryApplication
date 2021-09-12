package com.test.insurance.dao;

import com.test.insurance.model.Contract;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository("contractDao")
public class ContractDaoImpl implements ContractDao {
    private static final Logger logger = LoggerFactory.getLogger(ContractDaoImpl.class);

    @PersistenceContext
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
        Session session = this.sessionFactory.getCurrentSession();
        session.update(contract);
        logger.info("Contract successfully update. Contract details: " + contract);
    }

    @Override
    public void removeContract(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Contract contract = (Contract) session.load(Contract.class, new Integer(id));

        if(contract!=null){
            session.delete(contract);
        }
        logger.info("Contract successfully removed. Contract details: " + contract);
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

}
