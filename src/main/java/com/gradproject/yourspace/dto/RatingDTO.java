package com.gradproject.yourspace.dto;

import javax.validation.constraints.NotNull;

public class RatingDTO {


    @NotNull
    private int ratingId;

    @NotNull
    private String comment;
    @NotNull
    private float rating;

    @NotNull
    private int userId;

    @NotNull
    private int spaceId;

    public RatingDTO(){}


    public RatingDTO(int ratingId, String comment, float rating, int userId, int spaceId) {
        this.ratingId = ratingId;
        this.comment = comment;
        this.rating = rating;
        this.userId = userId;
        this.spaceId = spaceId;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }
}
