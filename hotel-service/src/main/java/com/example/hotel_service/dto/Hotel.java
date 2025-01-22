package com.example.hotel_service.dto;

import java.util.List;

public record Hotel(long hotelId, String hotelName, String hotelAddress, String about, List<Rating> reviews) {
}
