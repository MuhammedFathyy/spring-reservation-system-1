package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.SpaceDAO;
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
    public List<Space> getSpaces() {
       List<Space> spaces= spaceDAO.findAll(Sort.by(Sort.Direction.ASC, "name"));
       return spaces;
    }

    @Override
    @Transactional
    public Space getSpaceById(int id) {
        Space space= spaceDAO.findSpaceBySpaceId(id);
        if (space== null){
            throw new RuntimeException("There is no space with this data");
        }

        return space;

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

    public List<Space> getPageableSpace(int pageNo, int pageSize){

        //the sorting should be based on the location
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("spaceId").ascending());
        List< Space>spaces= spaceDAO.findAll(pageable).getContent();
        return spaces;

    }

    @Override
    @Transactional
    public Space getSpaceByRoomId(int roomId) {
        return spaceDAO.findSpaceByRoomId(roomId);
    }
}
