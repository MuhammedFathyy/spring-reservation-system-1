package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dto.AllSpacesDTO;
import com.gradproject.yourspace.dto.SpaceDTO;
import com.gradproject.yourspace.entity.Space;

import java.util.List;
import java.util.Map;

public interface SpaceService {
    public void saveSpace(Space space);
    public List<SpaceDTO> getSpaces();
    public SpaceDTO getSpaceById(int id);
    public String deleteSpaceById(int id);
   public void updateSpaceByFields(int spaceId, Map<String, Object> fields);
    public List<AllSpacesDTO> getLimitedSpaces(int page);

}
