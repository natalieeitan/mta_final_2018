package com.utilities;

import org.apache.commons.lang3.ObjectUtils;

public enum SchedulingRange{
    ANYTIME("Spontaneous",1),
    SEASON("Season",2),
    SPECIFIC("Specific",4)
    ;
    private String name;
    private int bitValue;

    SchedulingRange(final String name, final int bit) {
        this.name = name;
        this.bitValue=bit;
    }

    public String getName() {
        return name;
    }
    public int getBitValue(){return bitValue;}

    public static SchedulingRange convertIntToSchedulingRange(int value)
    {
        SchedulingRange result=null;

        for(SchedulingRange range:SchedulingRange.values())
        {
            if((range.getBitValue()&value)>0)
            {
                result = range;
                break;
            }
        }

        return result;
    }
}