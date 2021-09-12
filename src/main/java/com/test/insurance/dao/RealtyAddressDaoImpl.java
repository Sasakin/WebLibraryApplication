package com.test.insurance.dao;

import com.test.insurance.model.RealtyAddress;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("realtyAddressDao")
public class RealtyAddressDaoImpl implements RealtyAddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addRealtyAddress(RealtyAddress realtyAddress) {
        entityManager.unwrap(Session.class).persist(realtyAddress);
    }

    @Override
    @Transactional
    public void updateRealtyAddress(RealtyAddress realtyAddress) {
        entityManager.unwrap(Session.class).persist(realtyAddress);
    }

    @Override
    @Transactional
    public void removeRealtyAddress(int id) {
        RealtyAddress realtyAddress = (RealtyAddress) entityManager.unwrap(Session.class).load(RealtyAddress.class, new Integer(id));

        if(realtyAddress!=null){
            entityManager.unwrap(Session.class).delete(realtyAddress);
        }
    }

    @Override
    public RealtyAddress getRealtyAddressById(int id) {
        RealtyAddress realtyAddress = entityManager.unwrap(Session.class).load(RealtyAddress.class, new Integer(id));
        return realtyAddress;
    }

    @Override
    public List<RealtyAddress> listRealtyAddresss() {
        List<RealtyAddress> list = entityManager.unwrap(Session.class).createQuery("from RealtyAddress").getResultList();
        return list;
    }
}
