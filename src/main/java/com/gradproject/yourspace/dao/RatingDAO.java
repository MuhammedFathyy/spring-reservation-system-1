package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingDAO extends JpaRepository<Rating,Integer> {

    Rating findRatingByRatingId(int id);

    @Query(value = "select * from rating i where i.space_id = :id" ,
                  nativeQuery = true)
    List<Rating> findRatingBySpaceId(int id);
}
