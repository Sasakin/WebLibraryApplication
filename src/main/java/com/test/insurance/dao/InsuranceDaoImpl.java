package com.test.insurance.dao;

import com.test.insurance.model.Insurance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("insuranceDao")
public class InsuranceDaoImpl implements InsuranceDao {

    @Override
    public void addInsurance(Insurance insurance) {

    }

    @Override
    public void updateInsurance(Insurance insurance) {

    }

    @Override
    public void removeInsurance(int id) {

    }

    @Override
    public Insurance getInsuranceById(int id) {
        return null;
    }

    @Override
    public List<Insurance> listInsurances() {
        return null;
    }
}
