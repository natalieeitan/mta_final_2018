package com.utilities;

public enum Style{
    AnyStyle("AnyStyle"),
    Rural("Rural"),
    Classic("Classic"),
    Urban("Urban")
    ;
    private String name;

    Style(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}