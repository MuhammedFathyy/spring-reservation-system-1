package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingDAO extends JpaRepository<Rating,Integer> {

    Rating findRatingByRatingId(int id);
}
