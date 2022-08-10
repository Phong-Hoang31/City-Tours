package com.techelevator.model;

import java.sql.Time;

public class DayOfWeek {
    String dayName;
    Time openTime;
    Time closeTime;

    public DayOfWeek(String name, Time openTime, Time closeTime) {
        this.dayName = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }
    public DayOfWeek() {}

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }
}


