package com.gradproject.yourspace.dto;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.List;

public class SpaceDTO {

    @NotNull
    private int spaceId;

    @NotNull
    private String address;

    @NotNull
    private String district;

    @NotNull
    private int roomNumbers;

    @NotNull
    private String description;

    @NotNull
    private String name;

    @NotNull
    private String contactNumber;
    @NotNull
    private double minPrice;
    @NotNull
    private double maxPrice;
    @NotNull
    private Time startTime;
    @NotNull
    private Time endTime;
    @NotNull
    private Boolean drinks;
    @NotNull
    private  String owner;
    @NotNull
    private Boolean outdoors;
    @NotNull
    private double ratingAverage;

    @NotNull
    private List<ImageDTO> images;

    @NotNull
    private List<RatingDTO> ratings;



    public SpaceDTO() {
    }



    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(int roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Boolean getDrinks() {
        return drinks;
    }

    public void setDrinks(Boolean drinks) {
        this.drinks = drinks;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean getOutdoors() {
        return outdoors;
    }

    public void setOutdoors(Boolean outdoors) {
        this.outdoors = outdoors;
    }

    public double getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(double ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public List<ImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ImageDTO> images) {
        this.images = images;
    }

    public List<RatingDTO> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDTO> ratings) {
        this.ratings = ratings;
    }
}
