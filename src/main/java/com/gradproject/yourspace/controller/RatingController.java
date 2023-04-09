package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.entity.Rating;
import com.gradproject.yourspace.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/ratings")
public class RatingController {

    private RatingService ratingService;
    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping()
    public List<Rating> getAllRatings(){
        return ratingService.getRating();
    }

    @DeleteMapping({"{ratingId}"})
    public void deleteRating(@PathVariable int ratingId){
        ratingService.deleteRatingById(ratingId);
    }

    @PatchMapping({"{ratingId}"})
    public void updateRating(@PathVariable int ratingId, @RequestBody Map<String,Object> fields){
        ratingService.updateRatingByFields(ratingId,fields);
    }

    @PostMapping()
    public void addRating(@RequestBody Rating rating){
        ratingService.saveRating(rating);
    }
}
