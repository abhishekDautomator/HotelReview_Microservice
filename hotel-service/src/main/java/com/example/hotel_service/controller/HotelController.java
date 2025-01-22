package com.example.hotel_service.controller;

import com.example.hotel_service.dto.Hotel;
import com.example.hotel_service.service.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelServiceImpl hotelService;

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getAHotelDetails(@PathVariable("hotelId") long hotelId){
        Hotel hotel = hotelService.getAHotel(hotelId);
        return hotel!=null?new ResponseEntity<>(hotel, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotelDetails(){
        List<Hotel> hotels = hotelService.getAllHotel();
        return !hotels.isEmpty() ?new ResponseEntity<>(hotels, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Hotel> addAHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.saveAHotel(hotel), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Hotel> updateAHotelDetails(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.updateAHotel(hotel), HttpStatus.OK);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Boolean> deleteAHotel(@PathVariable("hotelId") long hotelId){
        return new ResponseEntity<>(hotelService.deleteAHotel(hotelId), HttpStatus.OK);
    }

}
