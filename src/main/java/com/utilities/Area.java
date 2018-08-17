package com.utilities;

public enum Area {
    ///todo - not worling with all values
    GushDan("Gush-Dan"),
    Haifa("Haifa"),
    Jerusalem("Jerusalem"),
    North("North"),
    Sharon("Sharon"),
    Shfela("Shfela"),
    South("South")
    ;
    private String name;

    Area(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}