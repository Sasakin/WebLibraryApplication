package com.test.insurance;

import com.test.insurance.calculator.InsuranceCalculator;
import com.test.insurance.model.*;
import com.test.insurance.service.ClientService;
import com.test.insurance.service.ContractService;
import com.test.insurance.service.InsuranceService;
import com.test.insurance.service.RealtyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

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

    @Autowired
    @Qualifier(value = "realtyAddressService")
    private RealtyAddressService realtyAddressService;

    public Insurance calcPremiumAndSave(Insurance insurance) {
        RealtyType realtyType = RealtyType.getTypeByTitle(insurance.getRealtyType());
        int buildYear = Integer.valueOf(insurance.getBuildYear());
        int square = Integer.valueOf(insurance.getSquare());
        double premium = calculator.calcInsurancePremium(insurance.getInsuredSum(), insurance.getStartDate(),
                insurance.getEndDate(), realtyType, buildYear, square);
        insurance.setPremium(String.valueOf(premium));
        insurance.setCalcDate(new Date());

        insuranceService.addInsurance(insurance);

        return insurance;
    }

    public void addContract(Contract contract, Insurance insurance,  Client client, RealtyAddress address) {
        contract.setInsurance(insurance);
        contract.setClient(client);
        contract.setAddress(address);
        contractService.addContract(contract);
    }

    public List<Contract> getContractList() {
        return contractService.listContracts();
    }

    public void removeContractById(int id) {
        contractService.removeContract(id);
    }

    public Contract getContractById(int id) {
        return contractService.getContractById(id);
    }

    public void addClient(Client client) {
        clientService.addClient(client);
    }

    public List<Client> getClientList() {
        return clientService.listClients();
    }

    public void updateClient(Client client) {
        clientService.updateClient(client);
    }


    public void addRealtyAddress(RealtyAddress address) {
        realtyAddressService.addRealtyAddress(address);
    }
}
