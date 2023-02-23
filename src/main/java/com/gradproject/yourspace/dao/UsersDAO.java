package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UsersDAO {

    public List<User> getUsers();

    public User getUser(int id);

    public void saveUser(int id);

    public void deleteUser(int id);
}
