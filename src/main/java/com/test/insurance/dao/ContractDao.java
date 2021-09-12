package com.test.insurance.dao;

import com.test.insurance.model.Contract;

import java.util.List;

public interface ContractDao {
    void addContract(Contract contract);

    void updateContract(Contract contract);

    void removeContract(int id);

    Contract getContractById(int id);

    List<Contract> listContracts();
}
