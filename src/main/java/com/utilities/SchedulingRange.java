package com.utilities;

public enum SchedulingRange{
    AnyTime("Spontaneous"),
    Season("Season"),
    Specific("Specific")
    ;
    private String name;

    SchedulingRange(final String name) {
        this.name = name;
    }
}
    /*    AnyTime("Spontaneous"),
    Season("Season"),
    Specific("Specific")*/