package com.techelevator.controller;

import com.techelevator.Exceptions.LandmarksNotFoundException;
import com.techelevator.dao.ItineraryDao;
import com.techelevator.dao.LandmarkDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
//@PreAuthorize("isAuthenticated()")
public class ItineraryController {

    private ItineraryDao itineraryDao;
    private UserDao userDao;
    private LandmarkDao landmarkDao;

    public ItineraryController(ItineraryDao itineraryDao, UserDao userDao, LandmarkDao landmarkDao) {
        this.itineraryDao = itineraryDao;
        this.userDao = userDao;
        this.landmarkDao = landmarkDao;
    }

    @GetMapping(path = "/itineraries")
    public List<Itinerary> getItineraries (Principal principal)  {
        int userId = userDao.findIdByUsername(principal.getName());
            return itineraryDao.getItinerariesByUserId(userId);
    }
}
