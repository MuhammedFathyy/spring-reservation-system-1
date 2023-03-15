package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceDAO extends JpaRepository<Space,Integer> {
    Space findSpaceBySpaceId(int id);


}
