package com.techelevator.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Itinerary not found")
public class IItineraryNotFoundException extends RuntimeException {

};

