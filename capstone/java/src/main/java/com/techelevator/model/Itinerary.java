package com.techelevator.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Itinerary {

    private int itineraryId;
    private String itineraryName;
    private int userId;
    private String startingPoint;
    private LocalDate itineraryDate;
    private ArrayList<Landmark> landmarkList;

    public Itinerary() {
    }

    public Itinerary(int itineraryId, String itineraryName, int userId, String startingPoint, LocalDate itineraryDate, ArrayList<Landmark> landmarkList) {
        this.itineraryId = itineraryId;
        this.itineraryName = itineraryName;
        this.userId = userId;
        this.startingPoint = startingPoint;
        this.itineraryDate = itineraryDate;
        this.landmarkList = landmarkList;
    }

    public int getItineraryId() {
        return itineraryId;
    }

    public String getItineraryName() {
        return itineraryName;
    }

    public int getUserId() {
        return userId;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public LocalDate getItineraryDate() {
        return itineraryDate;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
    }

    public void setItineraryName(String itineraryName) {
        this.itineraryName = itineraryName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public void setItineraryDate(LocalDate itineraryDate) {
        this.itineraryDate = itineraryDate;
    }
    public ArrayList<Landmark> getLandmarkList() {
        return landmarkList;
    }

    public void setLandmarkList(ArrayList<Landmark> landmarkList) {
        this.landmarkList = landmarkList;
    }

}
