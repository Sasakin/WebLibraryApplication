package com.test.insurance;

import com.test.insurance.dao.ContractDao;
import com.test.insurance.model.Contract;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContractRepositoryTest {

    @Autowired
    private ContractDao dao;

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
