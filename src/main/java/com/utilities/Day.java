package com.utilities;

import java.util.ArrayList;
import java.util.List;

public enum Day {
    SUNDAY("Sunday",1),
    MONDAY("Monday",2),
    TUESDAY("Tuesday",4),
    WEDNESDAY("Wednesday",8),
    THURSDAY("Thursday",16),
    FRIDAY("Friday",32),
    SATURDAY("Saturday",64)
    ;

    private String name;
    private int bitValue;

    Day(final String name,final int bit){
        this.name=name;
        this.bitValue=bit;
    }

    public String getName() {
        return name;
    }
    public int getBitValue(){return bitValue;}

    public static List<Day> ConvertIntToDaysList(int days)
    {
        List<Day> dayList=new ArrayList<>();
        for(Day day:Day.values())
        {
            if((day.getBitValue()&days)>0)
                dayList.add(day);
        }

        return dayList;
    }

    public static int convertDaysListToBits(List<Day> dayList)
    {
        int result=0;
        for(Day day: dayList)
        {
            result+=day.getBitValue();
        }
        return result;
    }

    public static int convertStringArrayDaysToBits(String[] DaysStr)
    {
        List<Day> daysList= new ArrayList<>();
        for(String day:DaysStr)
        {
            daysList.add(Day.valueOf(day));
        }
        return convertDaysListToBits(daysList);
    }
}
