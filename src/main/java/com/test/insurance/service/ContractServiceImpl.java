package com.test.insurance.service;

import com.test.insurance.dao.ContractDao;
import com.test.insurance.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("contractService")
public class ContractServiceImpl implements ContractService {
    @Autowired
    @Qualifier("contractDao")
    private ContractDao contractDao;

    public void setContractDao(ContractDao contractDao) {
        this.contractDao = contractDao;
    }

    @Override
    @Transactional
    public void addContract(Contract contract) {
        this.contractDao.addContract(contract);
    }

    @Override
    @Transactional
    public void updateContract(Contract contract) {
        this.contractDao.updateContract(contract);
    }

    @Override
    @Transactional
    public void removeContract(int id) {
        this.contractDao.removeContract(id);
    }

    @Override
    @Transactional
    public Contract getContractById(int id) {
        return this.contractDao.getContractById(id);
    }

    @Override
   // @Transactional
    public List<Contract> listContracts() {
        System.out.println("dao status");
        System.out.println(this.contractDao==null);
        return this.contractDao.listContracts();
    }

}
