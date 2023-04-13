package com.gradproject.yourspace.dto;

import com.gradproject.yourspace.entity.Rating;

import java.sql.Time;
import java.util.List;

public class SpaceDTO {
       private int spaceId;
       private String address;
       private String district;
       private String images;
       private int roomNumbers;
       private String description;
       private String name;
       private String contactNumber;
       private double minPrice;
       private double maxPrice;
       private Time startTime;
       private Time endTime;
       private Boolean drinks;
       private  String owner;
       private Boolean outdoors;
       private double ratingAverage;
       private List<Rating> ratingList;

    public SpaceDTO() {
    }

    public SpaceDTO(int spaceId, String address, String district, String images, int roomNumbers, String description, String name, String contactNumber, double minPrice, double maxPrice, Time startTime, Time endTime, Boolean drinks, String owner, Boolean outdoors, double ratingAverage, List<Rating> ratingList) {
        this.spaceId = spaceId;
        this.address = address;
        this.district = district;
        this.images = images;
        this.roomNumbers = roomNumbers;
        this.description = description;
        this.name = name;
        this.contactNumber = contactNumber;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.drinks = drinks;
        this.owner = owner;
        this.outdoors = outdoors;
        this.ratingAverage = ratingAverage;
        this.ratingList = ratingList;

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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
