package com.utilities;

public enum PriceRange{
    NoRange("NoRange"),
    OneFifty("150-200"),
    Two("200-250"),
    Three("300-350"),
    ThreeFifty("350-400"),
    Four("400-450"),
    FourFifty("450-500"),
    Five("500 and above")
    ;
    private String name;

    PriceRange(final String name) {
        this.name = name;
    }
}