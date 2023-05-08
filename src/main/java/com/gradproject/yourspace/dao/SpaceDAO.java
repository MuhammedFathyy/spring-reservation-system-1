package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceDAO extends JpaRepository<Space,Integer> {
    Space findSpaceBySpaceId(int id);



    @Query(value = "select * from space s , room r"+
            " where r.room_id = :id and r.space_id = s.space_id ",nativeQuery = true)
    Space findSpaceByRoomId(int id);
}
