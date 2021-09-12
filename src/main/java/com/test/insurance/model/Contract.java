package com.test.insurance.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Договор.
 */
@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(name = "DATE")
    private Date date;

    @OneToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "address_id")
    private RealtyAddress address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public RealtyAddress getAddress() {
        return address;
    }

    public void setAddress(RealtyAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", number=" + number +
                ", date=" + date +
                ", insurance=" + insurance +
                ", client=" + client +
                ", address=" + address +
                '}';
    }
}
