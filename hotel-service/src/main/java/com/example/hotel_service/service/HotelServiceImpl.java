package com.example.hotel_service.service;

import com.example.hotel_service.dto.Hotel;
import com.example.hotel_service.dto.Rating;
import com.example.hotel_service.repository.HotelEntity;
import com.example.hotel_service.repository.HotelRepository;
import com.example.hotel_service.utility.HotelHelperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelRepository repository;

//    @Value("${rating-service.getAHotelRatingsBaseURI}")
//    String clientBaseUrl;
//
//    @Autowired
//    @LoadBalanced
//    RestTemplate restTemplate;

    @Autowired
    RatingService ratingService;

    public List<Rating> getAHotelRatingsUsingClient(long hotelId){
        /*String clientUrl = clientBaseUrl+hotelId;
        return restTemplate.exchange(clientUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Rating>>() {}).getBody();*/
        return ratingService.getAHotelRatings(hotelId);
    }

    @Override
    public Hotel getAHotel(long hotelId) {
        HotelEntity hotelEntity = repository.findById(hotelId).orElseThrow(()-> new RuntimeException("No such hotel exists"));
        hotelEntity.setReviews(getAHotelRatingsUsingClient(hotelId));
        return HotelHelperMapper.toHotel(hotelEntity);
    }

    @Override
    public List<Hotel> getAllHotel() {
        List<HotelEntity> hotelEntities = repository.findAll();
        hotelEntities.forEach(hotelEntity -> hotelEntity.setReviews(getAHotelRatingsUsingClient(hotelEntity.getHotelId())));
        return hotelEntities.stream().map(HotelHelperMapper::toHotel).toList();
    }

    @Override
    public Hotel saveAHotel(Hotel hotel) {
        return HotelHelperMapper.toHotel(repository.save(HotelHelperMapper.toHotelEntity(hotel)));
    }

    @Override
    public Hotel updateAHotel(Hotel hotel) {
        HotelEntity existingHotel = repository.findById(hotel.hotelId())
                .orElseThrow(() -> new RuntimeException("No hotel exists with ID: " + hotel.hotelId()));
        existingHotel.setHotelAddress(hotel.hotelAddress());
        existingHotel.setHotelName(hotel.hotelName());
        existingHotel.setAbout(hotel.about());
        return HotelHelperMapper.toHotel(existingHotel);
    }

    @Override
    public boolean deleteAHotel(long hotelId) {
        if(repository.existsById(hotelId)) {
            repository.deleteById(hotelId);
            return true;
        }
        else throw new RuntimeException("No hotel exists by the given id");
    }
}
