package com.spbstu.lab4.enums;

public enum DIFF_ELEMENTS_DATA {
    CHECK_BOXES(new String[]{"Water", "Earth", "Wind", "Fire"}),
    RADIOS(new String[]{"Gold", "Silver", "Bronze", "Selen"}),
    DROP_COLORS(new String[]{"Red", "Green", "Blue", "Yellow"}),
    SELECT_ELEMENTS(new String[]{"Wind: condition changed to false", "Water: condition changed to false", "Colors: value changed to Yellow", "metal: value changed to Selen", "Water: condition changed to true", "Wind: condition changed to true"});

    public String[] strAr;
    public String str;

    DIFF_ELEMENTS_DATA(String[] strings) {
        strAr = strings;
    }
}