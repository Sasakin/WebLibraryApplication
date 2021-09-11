package com.test.insurance.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Рассчет.
 */
@Entity
@Table(name = "insurance")
public class Insurance {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "INSURED_SUM")
    private int insuredSum;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "REALTY_TYPE")
    private String realtyType;

    @Column(name = "BUILD_YEAR")
    private String buildYear;

    @Column(name = "SQUARE")
    private String square;

    @Column(name = "CALC_DATE")
    private Date calcDate;

    @Column(name = "PREMIUM")
    private String premium;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInsuredSum() {
        return insuredSum;
    }

    public void setInsuredSum(int insuredSum) {
        this.insuredSum = insuredSum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRealtyType() {
        return realtyType;
    }

    public void setRealtyType(String realtyType) {
        this.realtyType = realtyType;
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public Date getCalcDate() {
        return calcDate;
    }

    public void setCalcDate(Date calcDate) {
        this.calcDate = calcDate;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", insuredSum=" + insuredSum +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", realtyType='" + realtyType + '\'' +
                ", buildYear='" + buildYear + '\'' +
                ", square='" + square + '\'' +
                ", calcDate=" + calcDate +
                ", premium='" + premium + '\'' +
                '}';
    }
}
