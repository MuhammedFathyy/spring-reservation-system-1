package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ImageDAO extends JpaRepository<Image,Integer> {


    Image findImagesByImageId(int id);
    @Query(
            value = "select * from images i where i.space_id = :id ",
            nativeQuery = true)
    public List<Image> findImagesBySpaceId(int id);
    @Query(
            value = "select * from images i where i.room_id = :id ",
            nativeQuery = true)
    public List<Image> findImageByRoomId(int id);

    @Query(
            value = "select * from images i where i.user_id = :id ",
            nativeQuery = true)
    public Image findImagesByUserId(int id);
}
