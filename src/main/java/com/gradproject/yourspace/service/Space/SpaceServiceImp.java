package com.gradproject.yourspace.service.Space;

import com.gradproject.yourspace.dao.Space.SpaceDao;
import com.gradproject.yourspace.entity.Space;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SpaceServiceImp implements SpaceService{

    SpaceDao spaceDao;

    @Override
    @Transactional
    public void saveSpace(Space space) {
        spaceDao.save(space);
    }

    @Override
    @Transactional
    public List<Space> getSpaces() {
        return spaceDao.getSpaces();
    }

    @Override
    @Transactional
    public Space getSpaceById(int id) {
        return spaceDao.getById(id);
    }

    @Override
    @Transactional
    public void deleteSpaceById(int id) {
        spaceDao.deleteById(id);

    }

    @Autowired
    public SpaceServiceImp (SpaceDao spaceDao1){
        this.spaceDao= spaceDao1;
    }


}
