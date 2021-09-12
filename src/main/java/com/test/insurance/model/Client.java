package com.test.insurance.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String secondName;

    @Column(name = "SECOND_NAME")
    private String lastName;

    @Column(name = "BERTH_DAY")
    private Date berthDay;

    @Column(name = "PASPORT_SERIES")
    private int pasportSeries;

    @Column(name = "PASPORT_NUMBER")
    private int pasportNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBerthDay() {
        return berthDay;
    }

    public void setBerthDay(Date berthDay) {
        this.berthDay = berthDay;
    }

    public int getPasportSeries() {
        return pasportSeries;
    }

    public void setPasportSeries(int pasportSeries) {
        this.pasportSeries = pasportSeries;
    }

    public int getPasportNumber() {
        return pasportNumber;
    }

    public void setPasportNumber(int pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", berthDay=" + berthDay +
                ", pasportSeries=" + pasportSeries +
                ", pasportNumber=" + pasportNumber +
                '}';
    }
}
