package com.gradproject.yourspace.controller;


import com.gradproject.yourspace.dto.AllSpacesDTO;
import com.gradproject.yourspace.dto.SpaceDTO;
import com.gradproject.yourspace.entity.Space;
import com.gradproject.yourspace.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/spaces")
public class SpaceController {
    
    @Autowired
    private SpaceService spaceService;
    public SpaceController(SpaceService spaceService1){

        this.spaceService=spaceService1;
    }

    @GetMapping()
    public List<SpaceDTO> getSpaces(){
       return  spaceService.getSpaces();


    }

    @GetMapping("allspaces/{pageNo}")
    public List<AllSpacesDTO> getLimitedSpaces(@PathVariable int pageNo){
        return spaceService.getLimitedSpaces(pageNo);


    }
    @DeleteMapping("{spaceId}")
    public String deleteSpace(@PathVariable int spaceId){
     return  spaceService.deleteSpaceById(spaceId);

    }
    @GetMapping("{spaceId}")
    public SpaceDTO getSpace(@PathVariable int spaceId){
    return spaceService.getSpaceById(spaceId);
    }

    @PostMapping()
    public void addSpace(@RequestBody Space space){
        spaceService.saveSpace(space);
    }

    @PatchMapping("{spaceId}")
    public void updateSpaceByFields(@PathVariable int spaceId, @RequestBody Map<String,Object> fields){
        spaceService.updateSpaceByFields(spaceId,fields);

    }

}
