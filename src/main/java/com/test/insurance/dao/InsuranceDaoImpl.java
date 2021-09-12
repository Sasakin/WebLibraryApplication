package com.test.insurance.dao;

import com.test.insurance.model.Insurance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("insuranceDao")
public class InsuranceDaoImpl implements InsuranceDao {

    private static final Logger logger = LoggerFactory.getLogger(InsuranceDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addInsurance(Insurance insurance) {
        entityManager.unwrap(Session.class).persist(insurance);
        logger.info("Insurance successfully saved. Insurance details: " + insurance);
    }

    @Override
    @Transactional
    public void updateInsurance(Insurance insurance) {
        entityManager.unwrap(Session.class).persist(insurance);
        logger.info("Insurance successfully update. Insurance details: " + insurance);
    }

    @Override
    @Transactional
    public void removeInsurance(int id) {
        Insurance insurance = (Insurance) entityManager.unwrap(Session.class).load(Insurance.class, new Integer(id));

        if(insurance!=null){
            entityManager.unwrap(Session.class).delete(insurance);
        }
        logger.info("Insurance successfully removed. Insurance details: " + insurance);
    }

    @Override
    public Insurance getInsuranceById(int id) {
        Insurance insurance = entityManager.unwrap(Session.class).load(Insurance.class, new Integer(id));
        return insurance;
    }

    @Override
    public List<Insurance> listInsurances() {
        List<Insurance> list = entityManager.unwrap(Session.class).createQuery("from Insurance").getResultList();
        return list;
    }
}
