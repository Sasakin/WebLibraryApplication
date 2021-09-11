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

    public RealtyType getTypeByTitle(String typeTitle) {
        RealtyType type = Arrays.stream(values()).filter(p -> getTypeTitle().equals(typeTitle)).findAny().get();
        return type;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

}
