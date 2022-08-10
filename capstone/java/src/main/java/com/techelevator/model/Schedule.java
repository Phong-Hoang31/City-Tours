package com.techelevator.model;

import java.sql.Time;

public class Schedule {
    private int landmarkID;
    private Time openTime;
    private Time closeTime;
    private int dayOfWeek;

    public Schedule() {}

    public Schedule(int landmarkID, Time openTime, Time closeTime, int dayOfWeek) {
        this.landmarkID = landmarkID;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.dayOfWeek = dayOfWeek;
    }

    public int getLandmarkID() {
        return landmarkID;
    }

    public void setLandmarkID(int landmarkID) {
        this.landmarkID = landmarkID;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
