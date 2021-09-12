package com.test.insurance.service;

import com.test.insurance.dao.InsuranceDao;
import com.test.insurance.model.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("insuranceService")
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    @Qualifier("insuranceDao")
    private InsuranceDao insuranceDao;

    public void setInsuranceDao(InsuranceDao insuranceDao) {
        this.insuranceDao = insuranceDao;
    }

    @Override
    public void addInsurance(Insurance insurance) {
        insuranceDao.addInsurance(insurance);
    }

    @Override
    public void updateInsurance(Insurance insurance) {
        insuranceDao.updateInsurance(insurance);
    }

    @Override
    public void removeInsurance(int id) {
        insuranceDao.removeInsurance(id);
    }

    @Override
    public Insurance getInsuranceById(int id) {
        return insuranceDao.getInsuranceById(id);
    }

    @Override
    public List<Insurance> listInsurances() {
        return insuranceDao.listInsurances();
    }
}
