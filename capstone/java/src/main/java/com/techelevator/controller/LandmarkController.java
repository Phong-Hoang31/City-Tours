package com.techelevator.controller;

import com.techelevator.Exceptions.LandmarksNotFoundException;
import com.techelevator.dao.LandmarkDao;
import com.techelevator.model.Landmark;
import com.techelevator.model.Schedule;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping (path = "landmarks/upRatings/{landmarkId}")
    public Integer getRatingUpById (@PathVariable int landmarkId) throws LandmarksNotFoundException{
        return landmarkDao.getRatingUpById(landmarkId);
    }
    @GetMapping (path = "landmarks/downRatings/{landmarkId}")
    public Integer getRatingDownById (@PathVariable int landmarkId) throws LandmarksNotFoundException{
        return landmarkDao.getRatingDownById(landmarkId);
    }
    }

//    @GetMapping(path = "landmarks/{landmarkId}/images")
//    public ArrayList<String> getImagesByLandmarkId(@PathVariable int landmarkId) { return landmarkDao.getImagesByLandmarkId(landmarkId);}


