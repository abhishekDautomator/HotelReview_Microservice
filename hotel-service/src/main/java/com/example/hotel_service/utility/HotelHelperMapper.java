package com.example.hotel_service.utility;

import com.example.hotel_service.dto.Hotel;
import com.example.hotel_service.repository.HotelEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HotelHelperMapper {
    public static Hotel toHotel(HotelEntity hotelEntity){
        return new Hotel(hotelEntity.getHotelId(),
                hotelEntity.getHotelName(),
                hotelEntity.getHotelAddress(),
                hotelEntity.getAbout(),
                hotelEntity.getReviews());
    }

    public static HotelEntity toHotelEntity(Hotel hotel){
        return new HotelEntity(
                hotel.hotelName(),
                hotel.hotelAddress(),
                hotel.about());
    }
}
