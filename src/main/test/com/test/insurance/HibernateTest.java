package com.test.insurance;

import com.test.insurance.dao.ContractDao;
import com.test.insurance.model.Contract;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class HibernateTest {

    //private static SessionFactory sessionFactory = null;

    /*@BeforeClass
    public static void setUp() throws Exception
    {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }

    @AfterClass
    public static void tearDown() throws Exception
    {
        sessionFactory.close();
    }*/

    @Autowired
    @Qualifier("contractDao")
    ContractDao dao;

    @Test
    public void testSaveOperation()
    {
        System.out.println( "testSaveOperation begins ........ This is \"C\" of CRUD" );

        //Session session = sessionFactory.openSession();
        List<Contract> contractList = dao.listContracts();/// session.createQuery("from Contract").list();

        for(Contract contract: contractList){
            System.out.println("Contract list: " + contract);
        }
        //session.close();
        System.out.println( "testSaveOperation ends ......." );

    }
}
