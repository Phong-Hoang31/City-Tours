package com.techelevator.dao;

import com.techelevator.model.Landmark;
import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.List;

public interface LandmarkDao {

    List<Landmark> getLandmarks();
}
