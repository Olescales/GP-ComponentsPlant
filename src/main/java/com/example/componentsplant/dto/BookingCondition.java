package com.example.componentsplant.dto;

public enum BookingCondition {
    ONAPPROVEMENT("onApprovement"), ASSEMBLING("assembling"), READYFORSHIPMENT("readyForShipment"), SHIPPED("shipped");

    private String name;

    BookingCondition(String name) {
        this.name = name;
    }
}
