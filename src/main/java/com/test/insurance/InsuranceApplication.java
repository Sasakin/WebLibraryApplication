package com.test.insurance;

import com.test.insurance.model.Insurance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class InsuranceApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(InsuranceApplication.class, args);
        Insurance insurance = new Insurance();
        insurance.setInsuredSum(1000);
        insurance.setStartDate(new Date());
        insurance.setEndDate(new Date());
        insurance.setRealtyType("дом");
        insurance.setBuildYear("2015");
        insurance.setSquare("30");
        InsuranceFacade facade = context.getBean(InsuranceFacade.class);

        facade.calcPremiumAndSave(insurance);
    }
}
