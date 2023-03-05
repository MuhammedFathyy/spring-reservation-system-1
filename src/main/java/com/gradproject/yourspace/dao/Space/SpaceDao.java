package com.gradproject.yourspace.dao.Space;

import com.gradproject.yourspace.entity.Space;

import java.util.List;
import java.util.Map;

public interface SpaceDao {
    public void save(Space space);
    public void deleteById(int id);
    public Space getById(int id);
    public List<Space> getSpaces();


    public void updateSpaceByFields(int spaceId, Map<String, Object> fields);
}
