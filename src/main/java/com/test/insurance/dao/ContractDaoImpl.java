package com.test.insurance.dao;

import com.test.insurance.model.Contract;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("contractDao")
public class ContractDaoImpl implements ContractDao {
    private static final Logger logger = LoggerFactory.getLogger(ContractDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addContract(Contract contract) {
        entityManager.unwrap(Session.class).persist(contract);
        logger.info("Contract successfully saved. Contract details: " + contract);
    }

    @Override
    @Transactional
    public void updateContract(Contract contract) {
        entityManager.unwrap(Session.class).update(contract);
        logger.info("Contract successfully update. Contract details: " + contract);
    }

    @Override
    @Transactional
    public void removeContract(int id) {
        Contract contract = (Contract) entityManager.unwrap(Session.class).load(Contract.class, new Integer(id));

        if(contract!=null){
            entityManager.unwrap(Session.class).delete(contract);
        }
        logger.info("Contract successfully removed. Contract details: " + contract);
    }

    @Override
    public Contract getContractById(int id) {
        Contract contract = entityManager.unwrap(Session.class).load(Contract.class, new Integer(id));
        return contract;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contract> listContracts() {
        List<Contract> list = entityManager.unwrap(Session.class).createQuery("from Contract").getResultList();
        return list;
    }

}
