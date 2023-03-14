package com.gradproject.yourspace.service.Space;

import com.gradproject.yourspace.dao.SpaceRepository;
import com.gradproject.yourspace.entity.Space;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Time;
import java.util.List;
import java.util.Map;

@Service
public class SpaceServiceImp implements SpaceService{

    SpaceRepository spaceRepository;

    @Autowired
    public SpaceServiceImp (SpaceRepository spaceRepository){
        this.spaceRepository= spaceRepository;
    }

    @Override
    @Transactional
    public void saveSpace(Space space) {
       spaceRepository.save(space);
    }

    @Override
    @Transactional
    public List<Space> getSpaces() {
       return spaceRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    @Transactional
    public Space getSpaceById(int id) {
        return spaceRepository.findSpaceBySpaceId(id);
    }

    @Override
    @Transactional
    public void deleteSpaceById(int id) {
        spaceRepository.deleteById(id);

    }

    @Override
    @Transactional

    public void updateSpaceByFields(int spaceId, Map<String, Object> fields) {

        Space space =spaceRepository.findSpaceBySpaceId(spaceId);

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
        spaceRepository.save(space);
    }
}
