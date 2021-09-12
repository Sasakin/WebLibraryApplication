package com.test.insurance.calculator;

import com.test.insurance.model.RealtyType;
import org.springframework.stereotype.Component;

/**
 * Класс для получения коэфициентов
 * расчета страховой премии.
 */
@Component
public class InsuranceCoeffAdapter {

    /**
     * Коэфициент по типу недвижимости.
     * @param realtyType - тип недвижимости.
     * @return - коэффициент.
     */
    public Double getCoeffByRealtyType(RealtyType realtyType) {
        switch(realtyType) {
            case FLAT:
                return 1.7;
            case HOUSE:
                return 1.5;
            case ROOM:
                return 1.3;
        }

        return Double.NaN;
    }

    /**
     * Коэфициент по году постройки.
     * @param year - год постройки.
     * @return - коэффициент.
     */
    public Double getCoeffByBuildYear(int year){
        if(year < 2000) {
            return 1.3;
        }
        if(year >= 2000 && year <= 2014) {
            return 1.6;
        }
        if(year == 2015) {
            return 2.0;
        }

        return Double.NaN;
    }

    /**
     * Коэфициент по площади.
     * @param square - площадь
     * @return - коэффициент.
     */
    public Double getCoeffBySquare(int square){
        if(square < 50) {
            return 1.2;
        }
        if(square >= 50 && square <= 100) {
            return 1.5;
        }
        if(square > 100) {
            return 2.0;
        }

        return Double.NaN;
    }
}
