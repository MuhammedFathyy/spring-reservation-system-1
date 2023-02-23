package com.gradproject.yourspace.service;

import com.gradproject.yourspace.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public User getUser(int id);

    public void saveUser(User user);

    public void deleteUser(int id);
}
