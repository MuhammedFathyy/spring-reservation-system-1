package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDAO extends JpaRepository<User , Integer> {

    User findUserByUserId(int userId);


}
