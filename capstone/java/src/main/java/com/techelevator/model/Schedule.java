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

    public Schedule(String dayName, Time openTime, Time closeTime) {
        this.dayName = dayName;
        this.openTime = convertTime(openTime);
        this.closeTime = convertTime(closeTime);

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

    ;


    public static String convertTime(Time time) {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        long l = time.getTime();
        String dateString = dateFormat.format(new Date(l)).toString();
        return dateString;


    }

    }


