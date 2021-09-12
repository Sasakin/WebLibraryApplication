package com.test.insurance.model;

import javax.persistence.*;

@Entity
@Table(name = "realty_address")
public class RealtyAddress {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ADDRESS")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "RealtyAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
