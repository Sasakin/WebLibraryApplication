package com.test.insurance.model;

import java.util.Arrays;

/**
 * Типы недвижимости.
 */
public enum RealtyType {
    FLAT("квартира"),
    HOUSE("дом"),
    ROOM("комната");

    private String typeTitle;

    RealtyType(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    public static RealtyType getTypeByTitle(String rTypeTitle) {
        RealtyType type = Arrays.stream(values()).filter(rt -> rt.getTypeTitle().equals(rTypeTitle)).findAny().get();
        return type;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

}
