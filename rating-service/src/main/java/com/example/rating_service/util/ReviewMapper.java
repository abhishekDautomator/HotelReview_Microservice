package com.example.rating_service.util;

import com.example.rating_service.dto.Rating;
import com.example.rating_service.repository.RatingEntity;
import com.example.rating_service.service.SequenceGeneratorService;

public class ReviewMapper {
    public static Rating mapToRating(RatingEntity ratingEntity) {
        if (ratingEntity == null) {
            return null;
        }
        return new Rating(
                ratingEntity.getRatingId(),
                ratingEntity.getUserId(),
                ratingEntity.getHotelId(),
                ratingEntity.getRating(),
                ratingEntity.getReview()
        );
    }

    // Convert Rating to RatingEntity
    public static RatingEntity mapToRatingEntity(SequenceGeneratorService sequenceGeneratorService, Rating rating) {
        if (rating == null) {
            return null;
        }
        return new RatingEntity(
                sequenceGeneratorService,
                rating.userId(),
                rating.hotelId(),
                rating.rating(),
                rating.review()
        );
    }
}
