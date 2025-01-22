package com.example.hotel_service.repository;

import com.example.hotel_service.dto.Rating;
import jakarta.persistence.*;
import org.springframework.data.annotation.Persistent;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="hotel")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long hotelId;

    private String hotelName;

    private String hotelAddress;

    private String about;

    @Transient
    private List<Rating> reviews;

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Rating> getReviews() {
        return reviews;
    }

    public void setReviews(List<Rating> reviews) {
        this.reviews = reviews;
    }

    public HotelEntity() {
    }

    public HotelEntity(String hotelName, String hotelAddress, String about) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.about = about;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HotelEntity that = (HotelEntity) o;
        return Objects.equals(hotelId, that.hotelId) && Objects.equals(hotelName, that.hotelName) && Objects.equals(hotelAddress, that.hotelAddress) && Objects.equals(about, that.about) && Objects.equals(reviews, that.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, hotelName, hotelAddress, about, reviews);
    }

    @Override
    public String toString() {
        return "HotelEntity{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", about='" + about + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}

