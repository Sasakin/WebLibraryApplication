package com.test.insurance.model;

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
}
