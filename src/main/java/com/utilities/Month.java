package com.utilities;

import java.util.ArrayList;
import java.util.List;

public enum Month {
    JANUARY("January",1),
    FEBRUARY("February",2),
    MARCH("March",4),
    APRIL("April",8),
    MAY("May",16),
    JUNE("June",32),
    JULY("July",64),
    AUGUST("August",128),
    SEPTEMBER("September",256),
    OCTOBER("October",512),
    NOVEMBER("November",1024),
    DECEMBER("December",2048)
    ;

    private String name;
    private int bitValue;

    Month(final String name, final int bit){
        this.name=name;
        this.bitValue=bit;
    }

    public String getName() {
        return name;
    }
    public int getBitValue(){return bitValue;}

    public static List<Month> translateIntToMonthList(int months)
    {
        List<Month> monthList=new ArrayList<>();
        for(Month month:Month.values())
        {
            if((month.getBitValue()&months)>0)
                monthList.add(month);
        }

        return monthList;
    }

    public static int translateMonthListToInt(List<Month> monthList)
    {
        int result=0;
        for(Month month: monthList)
        {
            result+=month.getBitValue();
        }
        return result;
    }
}
