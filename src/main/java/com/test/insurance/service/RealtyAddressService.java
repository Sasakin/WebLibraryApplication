package com.test.insurance.service;

import com.test.insurance.model.RealtyAddress;

import java.util.List;

public interface RealtyAddressService {
    void addRealtyAddress(RealtyAddress realtyAddress);

    void updateRealtyAddress(RealtyAddress realtyAddress);

    void removeRealtyAddress(int id);

    RealtyAddress getRealtyAddressById(int id);

    List<RealtyAddress> listRealtyAddresss();
}
