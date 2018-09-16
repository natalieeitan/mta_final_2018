package com.utilities;

import java.util.ArrayList;
import java.util.List;

public enum Month {
    JANUARY("ינואר",1),
    FEBRUARY("פברואר",2),
    MARCH("מרץ",4),
    APRIL("אפריל",8),
    MAY("מאי",16),
    JUNE("יוני",32),
    JULY("יולי",64),
    AUGUST("אוגוסט",128),
    SEPTEMBER("ספטמבר",256),
    OCTOBER("אוקטובר",512),
    NOVEMBER("נובמבר",1024),
    DECEMBER("דצמבר",2048)
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

    public static List<Month> convertIntToMonthList(int months)
    {
        List<Month> monthList=new ArrayList<>();
        for(Month month:Month.values())
        {
            if((month.getBitValue()&months)>0)
                monthList.add(month);
        }

        return monthList;
    }

    public static int convertMonthListToBits(List<Month> monthList)
    {
        int result=0;
        for(Month month: monthList)
        {
            result+=month.getBitValue();
        }
        return result;
    }

    public static int convertStringArrayMonthToBits(String[] monthsStr)
    {
        List<Month> monthsList= new ArrayList<>();
        for(String month:monthsStr)
        {
            monthsList.add(Month.valueOf(month));
        }
        return convertMonthListToBits(monthsList);
    }

    public static String convertBitsMonthsList(int months) {
        String monthsString = "";
        for (Month month : Month.values()) {
            if ((month.getBitValue() & months) > 0) {
                monthsString = monthsString + month.getName()+", ";
            }
        }
        if(monthsString.endsWith(", ")){
            monthsString = monthsString.substring(0,monthsString.length() - 2);
        }
        return monthsString;
    }
}
