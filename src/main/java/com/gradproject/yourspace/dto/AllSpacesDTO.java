package com.gradproject.yourspace.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AllSpacesDTO {
    @NotNull
    private String name;
    @NotNull
    private String address;

    @NotNull
    private double ratingAverage;
    @NotNull
    private int spaceId;

    @NotNull
     private List<ImageDTO> images;




    public AllSpacesDTO() {
    }

    public AllSpacesDTO(String name, String address, double ratingAverage, int spaceId, List<ImageDTO> images) {
        this.name = name;
        this.address = address;
        this.ratingAverage = ratingAverage;
        this.spaceId = spaceId;
        this.images = images;
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

    public List<ImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ImageDTO> images) {
        this.images = images;
    }
}
