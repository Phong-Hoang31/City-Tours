package com.techelevator.controller;

import com.techelevator.Exceptions.LandmarksNotFoundException;
import com.techelevator.dao.LandmarkDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Landmark;
import com.techelevator.model.Schedule;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class LandmarkController {

    private LandmarkDao landmarkDao;
    private UserDao userDao;

    public LandmarkController(UserDao userDao, LandmarkDao landmarkDao) {
        this.userDao = userDao;
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

    @GetMapping(path = "landmarks/{landmarkId}/upRatings")
    public boolean getUserHasRated (@PathVariable int landmarkId, Principal principal) throws LandmarksNotFoundException{
        int userId = userDao.findIdByUsername(principal.getName());

        return landmarkDao.getUserHasRated(userId, landmarkId);
    }

    @PutMapping(path = "landmarks/{landmarkId}/upRatings")
    public void updateUpRatings (@PathVariable int landmarkId, Principal principal) throws LandmarksNotFoundException{
        int userId = userDao.findIdByUsername(principal.getName());
        landmarkDao.updateUserHasRated(userId, landmarkId);
        landmarkDao.updateUpRatings(landmarkId);
    }

    @PutMapping(path = "landmarks/{landmarkId}/downRatings")
    public void updateDownRatings (@PathVariable int landmarkId, Principal principal) throws LandmarksNotFoundException{
        int userId = userDao.findIdByUsername(principal.getName());
        landmarkDao.updateUserHasRated(userId, landmarkId);
        landmarkDao.updateDownRatings(landmarkId);
    }
    }

//    @GetMapping(path = "landmarks/{landmarkId}/images")
//    public ArrayList<String> getImagesByLandmarkId(@PathVariable int landmarkId) { return landmarkDao.getImagesByLandmarkId(landmarkId);}


