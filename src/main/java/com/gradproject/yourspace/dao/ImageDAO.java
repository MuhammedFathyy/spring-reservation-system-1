package com.gradproject.yourspace.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gradproject.yourspace.entity.Image;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageDAO extends JpaRepository<Image,Integer> {


    Image findImagesByImageId(int id);
}
