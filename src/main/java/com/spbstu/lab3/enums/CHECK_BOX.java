package com.spbstu.lab3.enums;

public enum CHECK_BOX {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private final String name;

    CHECK_BOX(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

