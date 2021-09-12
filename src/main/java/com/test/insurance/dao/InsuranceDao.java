package com.test.insurance.dao;

import com.test.insurance.model.Insurance;

import java.util.List;

public interface InsuranceDao {

    void addInsurance(Insurance insurance);

    void updateInsurance(Insurance insurance);

    void removeInsurance(int id);

    Insurance getInsuranceById(int id);

    List<Insurance> listInsurances();
}
