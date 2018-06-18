package com.spbstu.lab5.enums;

public enum PAGE_DATA {
    LOGIN("epam"),
    PASSWORD("1234"),
    EXPECTED_RESULT(new String[]{"Summary: 5, Elements: Water, Fire, Color: Red, Metal: Gold, Vegetables: Cucumber",
            "Summary: 9, Elements: Earth, Wind, Color: Green, Metal: Silver, Vegetables: Tomato, Salad",
            "Summary: 15, Elements: Earth, Fire, Color: Blue, Metal: Bronze, Vegetables: Tomato, Salad, Onion",
            "Summary: 11, Elements: Water, Wind, Color: Yellow, Metal: Selen, Vegetables: Cucumber, Onion",
            "Summary: 9, Elements: Water, Earth, Wind, Fire, Color: Blue, Metal: Selen, Vegetables: Cucumber, Tomato, Salad, Onion"}),
    ELEMENTS(new String[]{"Wind", "Water", "Earth", "Fire"}),
    VEGETABLES(new String[]{"Cucumber", "Salad", "Onion", "Tomato"});

    public String[] strAr;
    public String str;
    public Integer i;

    PAGE_DATA(String str) {
        this.str = str;
    }

    PAGE_DATA(Integer i) {
        this.i = i;
    }

    PAGE_DATA(String[] strAr) {
        this.strAr = strAr;
    }
}