package com.techelevator.model;

public class Landmark {
    private int landmarkID;
    private String landmarkName;
    private String venue;
    private String description;
    private int upRatings;
    private int downRatings;

    public Landmark() {

    }
    public Landmark(int landmarkID, String landmarkName, String venue, String description, int upRatings, int downRatings) {
        this.landmarkID = landmarkID;
        this.landmarkName = landmarkName;
        this.venue = venue;
        this.description = description;
        this.upRatings = upRatings;
        this.downRatings = downRatings;
    }
}
