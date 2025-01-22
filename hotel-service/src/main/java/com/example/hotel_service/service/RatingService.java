package com.example.hotel_service.service;

import com.example.hotel_service.dto.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "rating-service")
public interface RatingService {
    @GetMapping("/rating/hotel/{hotelId}")
    List<Rating> getAHotelRatings(@PathVariable long hotelId);
}
