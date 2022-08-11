package com.techelevator.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Landmark not found")
public class LandmarksNotFoundException extends RuntimeException {
}
