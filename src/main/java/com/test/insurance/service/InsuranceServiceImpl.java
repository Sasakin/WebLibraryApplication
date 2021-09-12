package com.test.insurance.service;

import com.test.insurance.dao.InsuranceDao;
import com.test.insurance.model.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("insuranceService")
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    @Qualifier("insuranceDao")
    private InsuranceDao dao;

    @Override
    public void addInsurance(Insurance insurance) {
        dao.addInsurance(insurance);
    }

    @Override
    public void updateInsurance(Insurance insurance) {
        dao.updateInsurance(insurance);
    }

    @Override
    public void removeInsurance(int id) {
        dao.removeInsurance(id);
    }

    @Override
    public Insurance getInsuranceById(int id) {
        return dao.getInsuranceById(id);
    }

    @Override
    public List<Insurance> listInsurances() {
        return dao.listInsurances();
    }
}
