package com.example.hotel_service.service;

import com.example.hotel_service.dto.Hotel;

import java.util.List;

public interface HotelService {
    Hotel getAHotel(long hotelId);
    List<Hotel> getAllHotel();
    Hotel saveAHotel(Hotel hotel);
    Hotel updateAHotel(Hotel hotel);
    boolean deleteAHotel(long hotelId);
}
