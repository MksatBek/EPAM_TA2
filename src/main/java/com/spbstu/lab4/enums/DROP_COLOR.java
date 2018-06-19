package com.spbstu.lab4.enums;

public enum DROP_COLOR {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private final String name;

    DROP_COLOR(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

