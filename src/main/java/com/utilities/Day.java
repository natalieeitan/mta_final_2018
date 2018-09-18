package com.utilities;

import java.util.ArrayList;
import java.util.List;

public enum Day {
    SUNDAY("ראשון",1),
    MONDAY("שני",2),
    TUESDAY("שלישי",4),
    WEDNESDAY("רביעי",8),
    THURSDAY("חמישי",16),
    FRIDAY("שישי",32),
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

    public static String convertBitsDaysList(int days) {
        String daysString = "";
        for (Day day : Day.values()) {
            if ((day.getBitValue() & days) > 0) {
                daysString = daysString + day.getName()+", ";
            }
        }
        if(daysString.endsWith(", ")){
            daysString = daysString.substring(0,daysString.length() - 2);
        }
        return daysString;
    }
}
