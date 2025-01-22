package com.example.rating_service.repository;

import com.example.rating_service.dto.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableMongoRepositories
public interface RatingRepository extends MongoRepository<RatingEntity, Long> {
    List<RatingEntity> findByUserId(long userId);
    List<RatingEntity> findByHotelId(long hotelId);
}
