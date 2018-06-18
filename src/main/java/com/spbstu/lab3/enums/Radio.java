package com.spbstu.lab3.enums;

public enum Radio {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private final String name;

    Radio(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
