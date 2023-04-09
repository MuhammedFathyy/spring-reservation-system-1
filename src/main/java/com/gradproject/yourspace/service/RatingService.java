package com.gradproject.yourspace.service;

import com.gradproject.yourspace.entity.Rating;

import java.util.List;
import java.util.Map;

public interface RatingService {
    public void saveRating(Rating rating);
    public List<Rating> getRating();
    public Rating getRatingById(int id);
    public void deleteRatingById(int id);
    public void updateRatingByFields(int ratingId, Map<String, Object> fields);
}
