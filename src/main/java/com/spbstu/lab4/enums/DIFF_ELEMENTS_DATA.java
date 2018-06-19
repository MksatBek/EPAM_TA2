package com.spbstu.lab4.enums;

public enum DIFF_ELEMENTS_DATA {

    SELECT_ELEMENTS(
            new String[]{
                    "Wind: condition changed to false",
                    "Water: condition changed to false",
                    "Colors: value changed to Yellow",
                    "metal: value changed to Selen",
                    "Water: condition changed to true",
                    "Wind: condition changed to true"});

    public String[] strArVal;
    public String str;

    DIFF_ELEMENTS_DATA(String[] strings) {
        strArVal = strings;
    }
}