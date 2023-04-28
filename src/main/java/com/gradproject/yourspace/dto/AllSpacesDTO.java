package com.gradproject.yourspace.dto;

import javax.validation.constraints.NotNull;

public class AllSpacesDTO {
    @NotNull
    private String name;
    @NotNull
    private String address;

    @NotNull
    private double ratingAverage;
    @NotNull
    private int spaceId;





    public AllSpacesDTO() {
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

}
