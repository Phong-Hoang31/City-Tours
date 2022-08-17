package com.techelevator.controller;

import com.techelevator.Exceptions.LandmarksNotFoundException;
import com.techelevator.dao.LandmarkDao;
import com.techelevator.model.Landmark;
import com.techelevator.model.Schedule;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class LandmarkController {

    private LandmarkDao landmarkDao;

    public LandmarkController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

    @GetMapping(path = "landmarks")
    public List<Landmark> getAllLandmarks() throws LandmarksNotFoundException{
        return landmarkDao.getLandmarks();
    }

    @GetMapping(path = "landmarks/{landmarkId}")
    public Landmark getLandmarksById (@PathVariable int landmarkId) throws LandmarksNotFoundException {
        return landmarkDao.getLandmarksById(landmarkId);
    }
    @PutMapping(path = "landmarks/{landmarkId}/upRatings")
    public void updateUpRatings (@PathVariable int landmarkId) throws LandmarksNotFoundException{
        landmarkDao.updateUpRatings(landmarkId);
    }
    @PutMapping(path = "landmarks/{landmarkId}/downRatings")
    public void updateDownRatings (@PathVariable int landmarkId) throws LandmarksNotFoundException{
        landmarkDao.updateDownRatings(landmarkId);
    }


    }

//    @GetMapping(path = "landmarks/{landmarkId}/images")
//    public ArrayList<String> getImagesByLandmarkId(@PathVariable int landmarkId) { return landmarkDao.getImagesByLandmarkId(landmarkId);}


