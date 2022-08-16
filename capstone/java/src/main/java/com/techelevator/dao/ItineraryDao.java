package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;

import java.time.LocalDate;
import java.util.List;

public interface ItineraryDao {

    public Itinerary getItineraryById(int itineraryId);
    public List<Itinerary> getItinerariesByUserId(int userId);
    public void createItinerary(String itineraryName, String startingPoint, LocalDate localDate, int userId);
    public void addLandmarkToItinerary(Integer itineraryId, Integer landmarkId);
    public void deleteLandmarkFromItinerary(Integer itineraryId, Integer landmarkId);
<<<<<<< HEAD
    public void deleteItinerary (int itineraryId);
=======
    public void updateItineraryStartingPoint(Integer itineraryId, String startingPoint);
>>>>>>> fec7f9729facc5d70b6ddf7e9e0cb97ad059e7bc
    }
