package com.test.insurance.service;

import com.test.insurance.model.Contract;

import java.util.List;

public interface ContractService {
    public void addContract(Contract contract);

    public void updateContract(Contract contract);

    public void removeContract(int id);

    public Contract getContractById(int id);

    public List<Contract> listContracts();

}
