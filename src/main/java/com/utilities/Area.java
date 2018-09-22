package com.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Area {

    GUSH_DAN("מרכז", 1),
    HAIFA("חיפה", 2),
    JERUSALEM("ירושלים", 4),
    NORTH("צפון", 8),
    SHARON("שרון", 16),
    SHFELA("שפלה", 32),
    SOUTH("דרום", 64);

    @Override
    public String toString() {
        return getName();
    }

    private String name;
    private int bitValue;

    Area(final String name, final int bit) {
        this.name = name;
        this.bitValue = bit;
    }

    public String getName() {
        return name;
    }

    public int getBitValue() {
        return bitValue;
    }

    public static String convertBitsAreasList(int areas) {
        String areasString = "";
        for (Area area : Area.values()) {
            if ((area.getBitValue() & areas) > 0) {
                areasString = areasString + area.getName()+", ";
            }
        }
        if(areasString.endsWith(", ")){
            areasString = areasString.substring(0,areasString.length() - 2);
        }
        return areasString;
    }

    public static List<Area> convertBitsToAreaList(int areas) {
        List<Area> areaList = new ArrayList<>();

        for (Area area : Area.values()) {
            if ((area.getBitValue() & areas) > 0) {
                areaList.add(area);
            }
        }

        return areaList;
    }

    public static int convertAreaListToBits(List<Area> areaList) {
        int result = 0;

        for (Area area : areaList) {
            result += area.getBitValue();
        }

        return result;
    }

    public static int convertStringArrayAreasToBits(String[] areaStr) {
        List<Area> areaList = new ArrayList<>();
        for (String area : areaStr) {
            areaList.add(Area.valueOf(area));
        }
        return convertAreaListToBits(areaList);
    }

    public static Area getAreaByInt(int area){
        return Arrays.stream(values())
                .filter(a -> a.getBitValue() == area)
                .findFirst()
                .orElse(null);
    }
}