package com.utilities;

public enum PriceRange{
    NoRange("NoRange"),
    One("100-150"),
    Two("200-250"),
    Three("300-350"),
    Four("400-450"),
    Five("500 and above")
    ;
    private String name;

    PriceRange(final String name) {
        this.name = name;
    }
}