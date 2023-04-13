package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.SpaceDAO;
import com.gradproject.yourspace.dto.AllSpacesDTO;
import com.gradproject.yourspace.dto.SpaceDTO;
import com.gradproject.yourspace.entity.Space;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SpaceServiceImpl implements SpaceService{

    SpaceDAO spaceDAO;

    @Autowired
    public SpaceServiceImpl(SpaceDAO spaceRepository){
        this.spaceDAO= spaceRepository;
    }

    @Override
    @Transactional
    public void saveSpace(Space space) {
        space.setSpaceId(0);
        spaceDAO.save(space);
    }

    @Override
    @Transactional
    public List<SpaceDTO> getSpaces() {
       List<Space> spaces= spaceDAO.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return  spaces.stream().map(this::convertSpaceDTO).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public SpaceDTO getSpaceById(int id) {
        Space space= spaceDAO.findSpaceBySpaceId(id);
        if (space== null){
            throw new RuntimeException("There is no space with this data");
        }
        return   convertSpaceDTO(space);
    }

    @Override
    @Transactional
    public String deleteSpaceById(int id) {
        Space space=spaceDAO.findSpaceBySpaceId(id);
        if (space== null){
            throw new RuntimeException("There is no space with this data");
        }
        spaceDAO.delete(space);
        return "space and associated rooms deleted successfully";

    }

    @Override
    @Transactional
    public void updateSpaceByFields(int spaceId, Map<String, Object> fields) {

        Space space =spaceDAO.findSpaceBySpaceId(spaceId);

        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Space.class, key);
            field.setAccessible(true);
            try {

                ReflectionUtils.setField(field, space, value);
            }
            catch(IllegalArgumentException exe){

                ReflectionUtils.setField(field, space, Time.valueOf((String) value));
            }
        });
        spaceDAO.save(space);
    }

    @Override
    @Transactional

    public List<AllSpacesDTO> getLimitedSpaces(int page){

        //the sorting should be based on the location
        Pageable pageable = PageRequest.of(page, 8, Sort.by("spaceId").ascending());
        List< Space>spaces= spaceDAO.findAll(pageable).getContent();
        return  spaces.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }
    private AllSpacesDTO convertEntityToDto(Space space){

        AllSpacesDTO spaceDTO= new AllSpacesDTO();
        spaceDTO.setName(space.getName());
        spaceDTO.setAddress(space.getAddress());
        spaceDTO.setImages(space.getImages());
        spaceDTO.setRatingAverage(space.getRatingAverage());
        spaceDTO.setSpaceId(space.getSpaceId());
        return spaceDTO;
    }
    private SpaceDTO convertSpaceDTO(Space space){

        SpaceDTO spaceDTO= new SpaceDTO();
        spaceDTO.setName(space.getName());
        spaceDTO.setAddress(space.getAddress());
        spaceDTO.setImages(space.getImages());
        spaceDTO.setRatingAverage(space.getRatingAverage());
        spaceDTO.setSpaceId(space.getSpaceId());
        spaceDTO.setRatingList(space.getRatings());
        spaceDTO.setContactNumber(space.getContactNumber());
        spaceDTO.setDrinks(space.isDrinks());
        spaceDTO.setDescription(space.getDescription());
        spaceDTO.setStartTime(space.getStartTime());
        spaceDTO.setEndTime(space.getEndTime());
        spaceDTO.setMaxPrice(space.getMaxPrice());
        spaceDTO.setMinPrice(space.getMinPrice());
        spaceDTO.setOutdoors(space.isOutdoors());
        spaceDTO.setOwner(space.getOwner());
        spaceDTO.setImages(space.getImages());
        spaceDTO.setRoomNumbers(space.getRoomNumbers());
        spaceDTO.setDistrict(space.getDistrict());
        return spaceDTO;
    }
}
