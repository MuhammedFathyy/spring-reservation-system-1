package com.gradproject.yourspace.dto;

public class AllSpacesDTO {

private String name;
private String address;
private String images;

private double ratingAverage;
private int spaceId;



    public AllSpacesDTO() {
    }

    public AllSpacesDTO(String name, String address, String images, double ratingAverage, int spaceId) {
        this.name = name;
        this.address = address;
        this.images = images;
        this.ratingAverage = ratingAverage;
        this.spaceId = spaceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }


    public double getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(double ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public int getSpaceId() {
        return spaceId;
    }


    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }
}
