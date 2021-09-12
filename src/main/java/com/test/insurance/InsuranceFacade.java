package com.test.insurance;

import com.test.insurance.calculator.InsuranceCalculator;
import com.test.insurance.model.Client;
import com.test.insurance.model.Contract;
import com.test.insurance.model.Insurance;
import com.test.insurance.model.RealtyType;
import com.test.insurance.service.ClientService;
import com.test.insurance.service.ContractService;
import com.test.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InsuranceFacade {

    @Autowired
    private InsuranceCalculator calculator;

    @Autowired
    @Qualifier("insuranceService")
    private InsuranceService insuranceService;

    @Autowired
    @Qualifier(value = "contractService")
    private ContractService contractService;

    @Autowired
    @Qualifier(value = "clientService")
    private ClientService clientService;

    public void calcPremiumAndSave(Insurance insurance) {
        RealtyType realtyType = RealtyType.getTypeByTitle(insurance.getRealtyType());
        int buildYear = Integer.valueOf(insurance.getBuildYear());
        int square = Integer.valueOf(insurance.getSquare());
        double premium = calculator.calcInsurancePremium(insurance.getInsuredSum(), insurance.getStartDate(),
                insurance.getEndDate(), realtyType, buildYear, square);
        insurance.setPremium(String.valueOf(premium));
        insurance.setCalcDate(new Date());

        insuranceService.addInsurance(insurance);

        Contract contract = new Contract();
        contract.setDate(new Date());
        contract.setInsurance(insurance);

        contractService.addContract(contract);
    }

    public void addClient(Client client) {
        clientService.addClient(client);
    }
}
