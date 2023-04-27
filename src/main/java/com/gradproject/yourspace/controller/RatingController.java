package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.dto.RatingDTO;
import com.gradproject.yourspace.entity.Rating;
import com.gradproject.yourspace.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/ratings")
public class RatingController {

    private RatingService ratingService;
    private ModelMapper modelMapper;

    public RatingController(RatingService ratingService, ModelMapper modelMapper) {
        this.ratingService = ratingService;
        this.modelMapper = modelMapper;
    }

    @Autowired


    @GetMapping()
    public List<RatingDTO> getAllRatings(){
        return ratingService.getRating().stream()
                .map(rating -> modelMapper.map(rating,RatingDTO.class))
                .collect(Collectors.toList());
    }
    @GetMapping("{ratingId}")
    public RatingDTO getRating(@PathVariable int ratingId){
        Rating rating= ratingService.getRatingById(ratingId);
        return  modelMapper.map(rating,RatingDTO.class);

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

    @GetMapping("space/{spaceId}")
    public List<RatingDTO> getRatingBySpaceId(@PathVariable int spaceId){
     return ratingService.getRatingBySpaceId(spaceId).stream()
             .map(rating -> modelMapper.map(rating,RatingDTO.class))
             .collect(Collectors.toList());
    }
}
