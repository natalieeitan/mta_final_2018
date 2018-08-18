package com.services;

import com.entities.Couple;
import com.utilities.SchedulingRange;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;


public class CoupleService {
    DataBaseServiceImpl dbService = new DataBaseServiceImpl();

    public void updateSchedulingRange(String id, SchedulingRange schedulingRange)
    {
        Couple couple = dbService.getCoupleById(id);
        couple.setSchedulingRange(schedulingRange);
        //todo ?
    }



}
