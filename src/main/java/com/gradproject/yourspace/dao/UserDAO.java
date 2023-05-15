package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDAO extends JpaRepository<User , Integer> {

    User findUserByUserId(int userId);


    User findUserByEmail(String email);

   Optional <User> findByUsername(String username);
}
