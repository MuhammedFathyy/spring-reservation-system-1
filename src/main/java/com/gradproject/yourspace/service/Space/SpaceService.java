package com.gradproject.yourspace.service.Space;

import com.gradproject.yourspace.entity.Space;
import java.util.List;

public interface SpaceService {
    public void saveSpace(Space space);
    public List<Space> getSpaces();
    public Space getSpaceById(int id);
    public void deleteSpaceById(int id);

}
