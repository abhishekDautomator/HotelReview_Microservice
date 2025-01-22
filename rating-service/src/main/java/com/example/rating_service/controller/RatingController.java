package com.example.rating_service.controller;

import com.example.rating_service.dto.Rating;
import com.example.rating_service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService service;

    @PostMapping()
    public ResponseEntity<Rating> addARating(@RequestBody Rating rating){
        return new ResponseEntity<>(service.createRating(rating), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Rating>> getAllRatings(){
        return new ResponseEntity<>(service.getAllRatings(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getAUserRatings(@PathVariable("userId") long userId){
        return new ResponseEntity<>(service.getAllRatingByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAHotelRatings(@PathVariable("hotelId") long hotelId){
        return new ResponseEntity<>(service.getAllRatingByHotelId(hotelId), HttpStatus.OK);
    }
}
