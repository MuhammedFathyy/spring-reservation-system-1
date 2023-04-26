package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RequestDAO extends JpaRepository<Request, Integer> {
    @Query(value = "select * from request where user_id =:userId", nativeQuery = true)
    List<Request> getRequestsByUserID(int userId);
}
