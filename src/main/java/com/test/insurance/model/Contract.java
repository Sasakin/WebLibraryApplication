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
    private int number;

    @Column(name = "DATE")
    private Date date;

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

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", number=" + number +
                ", date=" + date +
                '}';
    }
}
