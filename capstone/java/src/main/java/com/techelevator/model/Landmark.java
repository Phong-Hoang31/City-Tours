package com.techelevator.model;

public class Landmark {
    private int landmarkID;
    private String landmarkName;
    private String category;
    private String description;
    private int upRatings;
    private int downRatings;

    public Landmark() {

    }
    public Landmark(int landmarkID, String landmarkName, String category, String description, int upRatings, int downRatings) {
        this.landmarkID = landmarkID;
        this.landmarkName = landmarkName;
        this.category = category;
        this.description = description;
        this.upRatings = upRatings;
        this.downRatings = downRatings;
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
}
