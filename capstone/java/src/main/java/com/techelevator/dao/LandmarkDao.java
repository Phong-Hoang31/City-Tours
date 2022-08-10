package com.techelevator.dao;

import com.techelevator.model.DayOfWeek;
import com.techelevator.model.Landmark;
import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface LandmarkDao {

    List<Landmark> getLandmarks();
    ArrayList<String> getImagesByLandmarkId(int landmarkId);
    ArrayList<DayOfWeek> getSchedulesByLandmarkId(int landmarkId);
}
