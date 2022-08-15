package com.techelevator.model;

import java.util.ArrayList;

public class Landmark {
    private int landmarkId;
    private String landmarkName;
    private String category;
    private String description;
    private int upRatings;
    private int downRatings;
    private ArrayList<String> imageUrlList;
    private ArrayList<Schedule> scheduleList;
    private int landmarkOrder = 0;
    private String address;

    public Landmark(int landmarkId, String landmarkName, String category, String description, int upRatings, int downRatings, ArrayList<String> imageUrlList, ArrayList<Schedule> scheduleList, int landmarkOrder, String address, String price) {
        this.landmarkId = landmarkId;
        this.landmarkName = landmarkName;
        this.category = category;
        this.description = description;
        this.upRatings = upRatings;
        this.downRatings = downRatings;
        this.imageUrlList = imageUrlList;
        this.scheduleList = scheduleList;
        this.landmarkOrder = landmarkOrder;
        this.address = address;
        this.price = price;
    }

    public Landmark() {

    }

    public Landmark(int landmarkId, String landmarkName, String category, String description, int upRatings,
                    int downRatings, ArrayList<String> imageUrlList, ArrayList<Schedule> scheduleList, int landmarkOrder) {
        this.landmarkId = landmarkId;
        this.landmarkName = landmarkName;
        this.category = category;
        this.description = description;
        this.upRatings = upRatings;
        this.downRatings = downRatings;
        this.imageUrlList = imageUrlList;
        this.scheduleList = scheduleList;
        this.landmarkOrder = landmarkOrder;
    }

    public int getLandmarkID() {
        return landmarkId;
    }

    public void setLandmarkID(int landmarkId) {
        this.landmarkId = landmarkId;
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

    public int getLandmarkOrder() {
        return landmarkOrder;
    }

    public void setLandmarkOrder(int landmarkOrder) {
        this.landmarkOrder = landmarkOrder;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;
}
