package com.cg.model;

public enum EPayment {

    ORDER("ORDER"),
    DONE("DONE"),
    CANCEL("CANCEL"),
    BOMB("BOMB");

    private final String value;

    EPayment(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}