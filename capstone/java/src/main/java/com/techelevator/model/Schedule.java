package com.techelevator.model;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Schedule {
    String dayName;
    DateTimeFormatter openTime;
    DateTimeFormatter closeTime;

    public Schedule(String dayName, LocalTime openTime, LocalTime closeTime) {
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

    public DateTimeFormatter getOpenTime() {
        return openTime;
    }

    public void setOpenTime(DateTimeFormatter openTime) {
        this.openTime = openTime;
    }

    public DateTimeFormatter getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    ;


    public DateTimeFormatter convertTime(Time time) {
        ;

        String pattern = "hh:mm";


        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        return format;


    }
}

