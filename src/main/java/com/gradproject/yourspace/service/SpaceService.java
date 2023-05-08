package com.gradproject.yourspace.service;

import com.gradproject.yourspace.entity.Space;

import java.util.List;
import java.util.Map;

public interface SpaceService {
    public void saveSpace(Space space);
    public List<Space> getSpaces();
    public Space getSpaceById(int id);
    public String deleteSpaceById(int id);
   public void updateSpaceByFields(int spaceId, Map<String, Object> fields);
   public List<Space> getPageableSpace(int pageNo, int pageSize);

   public  Space getSpaceByRoomId(int roomId);
}
