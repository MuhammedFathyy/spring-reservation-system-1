package com.gradproject.yourspace.dto;

public class SpaceDTO {

private String name;
private String address;
private String images;
private double rating;

    public SpaceDTO() {
    }

    public SpaceDTO(String name, String address, String images, double rating) {
        this.name = name;
        this.address = address;
        this.images = images;
        this.rating = rating;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
