package com.test.insurance.dao;

import com.test.insurance.model.RealtyAddress;

import java.util.List;

public interface RealtyAddressDao {

    void addRealtyAddress(RealtyAddress realtyAddress);

    void updateRealtyAddress(RealtyAddress realtyAddress);

    void removeRealtyAddress(int id);

    RealtyAddress getRealtyAddressById(int id);

    List<RealtyAddress> listRealtyAddresss();
}
