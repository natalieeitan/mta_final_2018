package com.utilities;

import java.util.ArrayList;
import java.util.List;

public enum Style{
    AnyStyle("AnyStyle",1),
    Rural("Rural",2),
    Classic("Classic",4),
    Urban("Urban",8)
    ;
    private String name;
    private int bitValue;

    Style(final String name, final int bit) {
        this.name = name;
        this.bitValue=bit;
    }

    public String getName() {
        return name;
    }
    public int getBitValue(){return bitValue;}

    public static List<Style> translateIntToStyleList(int styles)
    {
        List<Style> styleList=new ArrayList<>();
        for(Style style:Style.values())
        {
            if((style.getBitValue()&styles)>0)
                styleList.add(style);
        }

        return styleList;
    }

    public static int translateStyleListToInt(List<Style> styleList)
    {
        int result=0;
        for(Style style: styleList)
        {
            result+=style.getBitValue();
        }
        return result;
    }
}