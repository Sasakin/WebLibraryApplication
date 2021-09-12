package com.test.insurance.calculator;


import com.test.insurance.model.RealtyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Класс для расчета страховой премии.
 */
@Component("insuranceCalculator")
public class InsuranceCalculator {


    private InsuranceCoeffAdapter insuranceCoeffAdapter;

    @Autowired
    public void setInsuranceCoeffAdapter(InsuranceCoeffAdapter insuranceCoeffAdapter) {
        this.insuranceCoeffAdapter = insuranceCoeffAdapter;
    }

    /**
     * Рассчет страховой премии.
     * @param insuredSum - страховая сумма.
     * @param startDate - срок действия с
     * @param endDate - срок действия по
     * @param realtyType - тип недвижимости
     * @param buildYear - год постройки
     * @param square - площадь
     * @return - сраховая премия.
     */
    public double calcInsurancePremium(int insuredSum, Date startDate, Date endDate,
                                       RealtyType realtyType, int buildYear, int square) {
        double premium = 0;
        int countDays = daysBetween(startDate, endDate);

        double coeffRealtyType = insuranceCoeffAdapter.getCoeffByRealtyType(realtyType);
        double coeffBuildYear = insuranceCoeffAdapter.getCoeffByBuildYear(buildYear);
        double coeffSquare = insuranceCoeffAdapter.getCoeffBySquare(square);

        premium = (insuredSum/countDays)*coeffRealtyType*coeffBuildYear*coeffSquare;

        return premium;
    }

    /**
     * Метод для расчет дней между датами.
     * Если переменные содержат одну и ту же дату - возвращает 1;
     * @param d1
     * @param d2
     * @return - колличество дней
     */
    public int daysBetween(Date d1, Date d2){
        int res = (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
        return res == 0 ? 1 : res;
    }

}
