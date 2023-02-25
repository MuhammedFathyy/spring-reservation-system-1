package com.gradproject.yourspace.controller;


import com.gradproject.yourspace.entity.Space;
import com.gradproject.yourspace.service.Space.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/space")
public class SpaceController {
    
    @Autowired
    private SpaceService spaceService;
    public SpaceController(SpaceService spaceService1){
        this.spaceService=spaceService1;
    }

    @GetMapping("allspaces")
    public List<Space> getSpaces(){
        return spaceService.getSpaces();
    }
    @DeleteMapping("{spaceId}")
    public String deleteSpace(@PathVariable int spaceId){
        Space space=spaceService.getSpaceById(spaceId);
        if (space== null){
            throw new RuntimeException("There is no space with this data");
        }
        spaceService.deleteSpaceById(spaceId);
        return "space and associated rooms deleted successfully";

    }
    @GetMapping("{spaceId}")
    public Space getSpace(@PathVariable int spaceId){
        Space space= spaceService.getSpaceById(spaceId);
        if (space== null){
            throw new RuntimeException("There is no space with this data");
        }

        return space;

    }
    @PostMapping()
    public Space addSpace(@RequestBody Space space){
        space.setSpaceId(0);
        spaceService.saveSpace(space);
        return space;


    }
    @PutMapping()
    public Space updateSpace(@RequestBody Space space){
        spaceService.saveSpace(space);
        return space;
    }

}
