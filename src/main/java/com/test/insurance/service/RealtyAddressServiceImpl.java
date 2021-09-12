package com.test.insurance.service;

import com.test.insurance.dao.RealtyAddressDao;
import com.test.insurance.model.RealtyAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("realtyAddressService")
public class RealtyAddressServiceImpl implements RealtyAddressService {

    @Autowired
    @Qualifier("realtyAddressDao")
    private RealtyAddressDao dao;

    @Override
    public void addRealtyAddress(RealtyAddress realtyAddress) {
        dao.addRealtyAddress(realtyAddress);
    }

    @Override
    public void updateRealtyAddress(RealtyAddress realtyAddress) {
        dao.updateRealtyAddress(realtyAddress);
    }

    @Override
    public void removeRealtyAddress(int id) {
        dao.removeRealtyAddress(id);
    }

    @Override
    public RealtyAddress getRealtyAddressById(int id) {
        return dao.getRealtyAddressById(id);
    }

    @Override
    public List<RealtyAddress> listRealtyAddresss() {
        return dao.listRealtyAddresss();
    }
}
