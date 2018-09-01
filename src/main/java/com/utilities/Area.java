package com.utilities;

import java.util.ArrayList;
import java.util.List;

public enum Area {

    ///todo - not worling with all values
    GUSH_DAN("Gush-Dan", 1),
    HAIFA("Haifa", 2),
    JERUSALEM("Jerusalem", 4),
    NORTH("North", 8),
    SHARON("Sharon", 16),
    SHFELA("Shfela", 32),
    SOUTH("South", 64);

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
}