package com.example.rating_service.service;

import com.example.rating_service.dto.Rating;
import com.example.rating_service.repository.RatingEntity;
import com.example.rating_service.repository.RatingRepository;
import com.example.rating_service.util.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Rating createRating(Rating rating) {
        RatingEntity ratingEntity = new RatingEntity(sequenceGeneratorService, rating.userId(), rating.hotelId(), rating.rating(), rating.review());
        return ReviewMapper.mapToRating(repository.save(ratingEntity));
    }

    @Override
    public List<Rating> getAllRatingByUserId(long userId) {
        return repository.findByUserId(userId).stream().map(ReviewMapper::mapToRating).toList();
    }

    @Override
    public List<Rating> getAllRatingByHotelId(long hotelId) {
        return repository.findByHotelId(hotelId).stream().map(ReviewMapper::mapToRating).toList();
    }

    @Override
    public List<Rating> getAllRatings() {
        return repository.findAll().stream().map(ReviewMapper::mapToRating).toList();
    }
}
