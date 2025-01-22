package com.example.rating_service.service;

import com.example.rating_service.dto.Rating;

import java.util.List;


public interface RatingService {

    Rating createRating(Rating rating);
    List<Rating> getAllRatingByUserId(long userId);
    List<Rating> getAllRatingByHotelId(long hotelId);
    List<Rating> getAllRatings();
}
