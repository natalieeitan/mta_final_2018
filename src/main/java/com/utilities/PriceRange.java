package com.utilities;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public enum PriceRange {
    NO_RANGE("NoRange", 1),
    ONE_FIFTY("151-200", 2),
    TWO_HUNDRED("201-250", 4),
    TWO_FIFTY("251-300", 8),
    THREE_HUNDRED("301-350", 16),
    THREE_FIFTY("351-400", 32),
    FOUR_HUNDRED("401-450", 64),
    FOUR_FIFTY("451-500", 128),
    FIVE_HUNDRED("501 and above", 256);
    private String name;
    private int bitValue;

    PriceRange(final String name, int bit) {
        this.name = name;
        this.bitValue = bit;
    }

    public String getName() {
        return name;
    }

    public int getBitValue() {
        return bitValue;
    }

    public static PriceRange convertBitsToPriceRange(int value) {
        for (PriceRange pr : PriceRange.values()) {
            if ((pr.getBitValue() & value) > 0)
                return pr;
        }

        return PriceRange.NO_RANGE;
    }


    public int getBottomValue(){
        String bottomString=getName().substring(0,3);
        int value= Integer.parseInt(bottomString);

        return value;
    }

    public int getTopValue(){
        String topString=getName().substring(4,7);
        int value= Integer.parseInt(topString);

        return value;
    }
}