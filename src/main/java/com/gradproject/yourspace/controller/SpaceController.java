package com.gradproject.yourspace.controller;


import com.gradproject.yourspace.dto.AllSpacesDTO;
import com.gradproject.yourspace.dto.SpaceDTO;
import com.gradproject.yourspace.entity.Space;
import com.gradproject.yourspace.service.SpaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/spaces")
public class SpaceController {
    
    @Autowired
    private SpaceService spaceService;
    @Autowired
    private ModelMapper modelMapper;

    public SpaceController(SpaceService spaceService, ModelMapper modelMapper) {
        this.spaceService = spaceService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<SpaceDTO> getSpaces(){
      return  spaceService.getSpaces() .stream()
              .map(space -> modelMapper.map(space, SpaceDTO.class))
              .collect(Collectors.toList());

    }

    @GetMapping("allspaces/{pageNo}/{pageSize}")
    public List<AllSpacesDTO> getLimitedSpaces(@PathVariable int pageNo,@PathVariable int pageSize){
        return spaceService.getPageableSpace(pageNo,pageSize)
                .stream().map(space->modelMapper.map(space, AllSpacesDTO.class))
                .collect(Collectors.toList());


    }

    @GetMapping("alldata/{pageNo}/{pageSize}")
    public List <SpaceDTO> getAllData(@PathVariable int pageNo,@PathVariable int pageSize){
       return  spaceService.getPageableSpace(pageNo,pageSize)
                .stream().map(space->modelMapper.map(space,SpaceDTO.class))
                .collect(Collectors.toList());

    }
    @DeleteMapping("{spaceId}")
    public String deleteSpace(@PathVariable int spaceId){
     return  spaceService.deleteSpaceById(spaceId);

    }
    @GetMapping("{spaceId}")
    public SpaceDTO getSpace(@PathVariable int spaceId){

       Space space= spaceService.getSpaceById(spaceId);
       return modelMapper.map(space,SpaceDTO.class);

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
