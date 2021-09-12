package com.test.insurance.service;

import com.test.insurance.model.Contract;
import com.test.insurance.model.Insurance;

import java.util.List;

public interface InsuranceService {

    void addInsurance(Insurance insurance);

    void updateInsurance(Insurance insurance);

    void removeInsurance(int id);

    Insurance getInsuranceById(int id);

    List<Insurance> listInsurances();
}
