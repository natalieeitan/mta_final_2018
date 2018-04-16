package com.utilities;

public enum Area {
    North("North"),
    Haifa("Haifa"),
    Center("SpecificDate"),
    TelAviv("Tal-Aviv"),
    Jerusalem("Jerusalem"),
    Shfela("Shfela"),
    South("South")
    ;
    private String name;

    Area(final String name) {
        this.name = name;
    }
}