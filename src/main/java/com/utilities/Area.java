package com.utilities;

public enum Area {
    ///todo - not worling with all values
    North("north"),
    Haifa("Haifa"),
    Center("Center"),
    TelAviv("Tal-Aviv"),
    Jerusalem("Jerusalem"),
    Shfela("shfela"),
    Sharon("sharon"),
    South("south")
    ;
    private String name;

    Area(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}