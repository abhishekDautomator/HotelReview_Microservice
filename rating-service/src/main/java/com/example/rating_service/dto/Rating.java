package com.example.rating_service.dto;

public record Rating(long ratingId, long userId, long hotelId, int rating, String review) {
}
