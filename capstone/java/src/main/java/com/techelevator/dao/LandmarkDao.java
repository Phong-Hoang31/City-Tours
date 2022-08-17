package com.techelevator.dao;

import com.techelevator.model.Landmark;
import com.techelevator.model.Schedule;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public interface LandmarkDao {

    List<Landmark> getLandmarks();
    ArrayList<String> getImagesByLandmarkId(int landmarkId);
    ArrayList<Schedule> getSchedulesByLandmarkId(int landmarkId);
    Landmark getLandmarksById(int landmarkId);
    ArrayList<Landmark> getLandmarksByItineraryId(int itineraryId);
    Landmark mapToRowSet(SqlRowSet sqlRowSet);
    boolean getUserHasRated(int userId, int landmarkId);
    void updateUserHasRated(int userId, int landmarkId);
    void updateUpRatings(int landmarkId);
    void updateDownRatings(int landmarkId);
}
