package com.example.hotel_service.dto;

public record Rating(long ratingId, long userId, String hotelId, int rating, String review) {
}
