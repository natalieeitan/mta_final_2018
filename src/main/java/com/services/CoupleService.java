package com.services;

import com.entities.Couple;
import com.utilities.SchedulingRange;


public class CoupleService {
    DataBaseServiceImpl dbService = new DataBaseServiceImpl();

    public void updateSchedulingRange(String id, SchedulingRange schedulingRange)
    {
        Couple couple = dbService.getCoupleById(id);
        couple.setSchedulingRange(schedulingRange);
        //todo ?
    }
}
