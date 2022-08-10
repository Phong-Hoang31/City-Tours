package com.techelevator.model;

import java.util.ArrayList;

public class Landmark {
    private int landmarkID;
    private String landmarkName;
    private String category;
    private String description;
    private int upRatings;
    private int downRatings;
    private ArrayList<String> imageUrlList;
    private ArrayList<Schedule> scheduleList;

    public Landmark() {

    }

    public Landmark(int landmarkID, String landmarkName, String category, String description, int upRatings, int downRatings, ArrayList<String> imageUrlList, ArrayList<Schedule> scheduleList) {
        this.landmarkID = landmarkID;
        this.landmarkName = landmarkName;
        this.category = category;
        this.description = description;
        this.upRatings = upRatings;
        this.downRatings = downRatings;
        this.imageUrlList = imageUrlList;
        this.scheduleList = scheduleList;
    }

    public int getLandmarkID() {
        return landmarkID;
    }

    public void setLandmarkID(int landmarkID) {
        this.landmarkID = landmarkID;
    }

    public String getLandmarkName() {
        return landmarkName;
    }

    public void setLandmarkName(String landmarkName) {
        this.landmarkName = landmarkName;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUpRatings() {
        return upRatings;
    }

    public void setUpRatings(int upRatings) {
        this.upRatings = upRatings;
    }

    public int getDownRatings() {
        return downRatings;
    }

    public void setDownRatings(int downRatings) {
        this.downRatings = downRatings;
    }

    public ArrayList<String> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(ArrayList<String> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public ArrayList<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(ArrayList<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
