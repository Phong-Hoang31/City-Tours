package com.techelevator.model;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class Schedule {
    String dayName;
    String openTime;
    String closeTime;

    public Schedule(String dayName, String openTime, String closeTime) {
        this.dayName = dayName;
        this.openTime = openTime;
        this.closeTime = closeTime;

    }

    public Schedule() {
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }


    }


