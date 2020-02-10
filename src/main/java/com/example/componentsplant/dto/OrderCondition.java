package com.example.componentsplant.dto;

public enum OrderCondition {
    ONAPPROVEMENT("onApprovement"), ASSEMBLING("assembling"), READYFORSHIPMENT("readyForShipment"), SHIPPED("shipped");

    private String name;

    OrderCondition(String name) {
        this.name = name;
    }
}
