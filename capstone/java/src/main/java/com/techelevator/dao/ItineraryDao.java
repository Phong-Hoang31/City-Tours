package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;

import java.time.LocalDate;
import java.util.List;

public interface ItineraryDao {

    public Itinerary getItineraryById(int itineraryId);
    public List<Itinerary> getItinerariesByUserId(int userId);
    public void createItinerary(String itinerary_name, String starting_point, LocalDate localDate, int user_id);
    public void addLandmarkToItinerary(Integer itineraryId, Integer landmarkId);

    }
