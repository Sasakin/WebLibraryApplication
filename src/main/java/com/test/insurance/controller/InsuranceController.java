package com.test.insurance.controller;

import com.test.insurance.InsuranceFacade;
import com.test.insurance.model.Client;
import com.test.insurance.model.Contract;
import com.test.insurance.model.Insurance;
import com.test.insurance.model.RealtyAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InsuranceController {

    @Autowired
    private InsuranceFacade facade;

    //test
    public void createContract(Contract contract) {
        Insurance insurance = new Insurance();
        insurance.setInsuredSum(1000);
        insurance.setStartDate(new Date());
        insurance.setEndDate(new Date());
        insurance.setRealtyType("дом");
        insurance.setBuildYear("2015");
        insurance.setSquare("30");

        facade.calcPremiumAndSave(insurance);

        Client client = new Client();
        client.setFirstName("Re");
        client.setSecondName("Te");
        client.setLastName("De");
        client.setBerthDay(new Date());
        client.setPasportSeries(123123);
        client.setPasportNumber(123123);

        facade.addClient(client);

        RealtyAddress address = new RealtyAddress();

        address.setAddress("Saint Petersburg");
        facade.addRealtyAddress(address);

        facade.addContract(contract, insurance, client, address);

        System.out.println("contract details:" + contract);
    }

    //test
    public void createContract() {
        Contract contract = new Contract();
        contract.setDate(new Date());
        createContract(contract);
    }

}
