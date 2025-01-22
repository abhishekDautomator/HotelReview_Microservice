package com.example.rating_service.repository;

import com.example.rating_service.service.SequenceGeneratorService;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

@Document("ratings")
public class RatingEntity {
    @MongoId
    private long ratingId;

    private long userId;

    private long hotelId;

    private int rating;

    private String review;

    public long getRatingId() {
        return ratingId;
    }

    public void setRatingId(long ratingId) {
        this.ratingId = ratingId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public RatingEntity() {
    }

    public RatingEntity(SequenceGeneratorService seqService, long userId, long hotelId, int rating, String review) {
        this.ratingId = seqService.getNextSequence("RatingEntity");
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RatingEntity that = (RatingEntity) o;
        return ratingId == that.ratingId && userId == that.userId && hotelId == that.hotelId && rating == that.rating && Objects.equals(review, that.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingId, userId, hotelId, rating, review);
    }

    @Override
    public String toString() {
        return "RatingEntity{" +
                "ratingId=" + ratingId +
                ", userId=" + userId +
                ", hotelId=" + hotelId +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
