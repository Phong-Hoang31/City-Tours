package com.techelevator.dao;

import com.techelevator.model.Itinerary;

import java.time.LocalDate;
import java.util.List;

public interface ItineraryDao {

    public Itinerary getItineraryById(int itineraryId);
    public List<Itinerary> getItinerariesByUserId(int userId);
    public void createItinerary(String itineraryName, String startingPoint, LocalDate localDate, int userId);
    public void addLandmarkToItinerary(int itineraryId, int landmarkId);
    public void deleteLandmarkFromItinerary(int itineraryId, int landmarkId);
    public void deleteItinerary (int itineraryId);
    public void updateItineraryName(int itineraryId, Itinerary itinerary);
    public void incrementLandmarkOrder(int itineraryId, int currentLandmarkOrder);
    public void decrementLandmarkOrder(int itineraryId, int currentLandmarkOrder);
}
