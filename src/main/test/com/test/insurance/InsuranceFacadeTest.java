package com.test.insurance;

import com.test.insurance.calculator.InsuranceCalculator;
import com.test.insurance.calculator.InsuranceCoeffAdapter;
import com.test.insurance.model.Client;
import com.test.insurance.model.Insurance;
import com.test.insurance.service.ClientService;
import com.test.insurance.service.ContractService;
import com.test.insurance.service.InsuranceService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;

public class InsuranceFacadeTest {

    @InjectMocks
    private InsuranceFacade facade;

    @Mock
    private InsuranceCalculator calculator;

    @Mock
    private InsuranceCoeffAdapter insuranceCoeffAdapter;

    @Mock
    private ContractService contractService;

    @Mock
    private InsuranceService insuranceService;

    @Mock
    private ClientService clientService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

   // @Test
    public void testCalcAndSaveInsurance() {
        Insurance insurance = new Insurance();
        insurance.setInsuredSum(1000);
        insurance.setStartDate(new Date());
        insurance.setEndDate(new Date());
        insurance.setRealtyType("дом");
        insurance.setBuildYear("2015");
        insurance.setSquare("30");

        facade.calcPremiumAndSave(insurance);
        Mockito.when(insuranceService.getInsuranceById(insurance.getId())).thenReturn(insurance);

    }

    @Test
    public void testInsertClient() {
        Client client = Mockito.mock(Client.class);
        Mockito.mock(Client.class);

        Mockito.when(clientService.getClientById(client.getId())).thenReturn(client);

    }
}
