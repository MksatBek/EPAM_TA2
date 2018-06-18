package com.spbstu.lab3.enums;

public enum DropColor {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private final String name;

    DropColor(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

