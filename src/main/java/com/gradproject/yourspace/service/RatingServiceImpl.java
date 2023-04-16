package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.RatingDAO;
import com.gradproject.yourspace.dao.SpaceDAO;
import com.gradproject.yourspace.entity.Rating;
import com.gradproject.yourspace.entity.Space;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class RatingServiceImpl implements RatingService {

    RatingDAO ratingDAO;
    SpaceDAO spaceDAO;
    @Autowired
    public RatingServiceImpl(RatingDAO ratingDAO, SpaceDAO spaceDAO) {
        this.ratingDAO = ratingDAO;
        this.spaceDAO = spaceDAO;
    }




    @Override
    @Transactional
    public void saveRating(Rating rating) {
        rating.setRatingId(0);
        ratingDAO.save(rating);
        int spaceId= rating.getSpace().getSpaceId();
        Space space= spaceDAO.findSpaceBySpaceId(spaceId);
        space.setRatingAverage();
        spaceDAO.save(space);

    }

    @Override
    @Transactional
    public List<Rating> getRating() {
        return ratingDAO.findAll();
    }

    @Override
    @Transactional
    public Rating getRatingById(int id) {
        return ratingDAO.findRatingByRatingId(id);
    }

    @Override
    @Transactional
    public void deleteRatingById(int id) {
        Rating rating=ratingDAO.findRatingByRatingId(id);
        ratingDAO.delete(rating);

    }

    @Override
    @Transactional
    public void updateRatingByFields(int ratingId, Map<String, Object> fields) {
        Rating rating =ratingDAO.findRatingByRatingId(ratingId);

        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Rating.class, key);
            field.setAccessible(true);

                ReflectionUtils.setField(field, rating, value);

        });
        ratingDAO.save(rating);

    }
}
