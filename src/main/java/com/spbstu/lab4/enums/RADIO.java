package com.spbstu.lab4.enums;

public enum RADIO {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private final String name;

    RADIO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
