package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dto.UserDTO;
import com.gradproject.yourspace.entity.Booking;
import com.gradproject.yourspace.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public UserDTO getUser(int id);

    public void saveUser(User user);

    public void updateUser(int userId, HashMap<String, Object> fields);

    public void deleteUser(int id);

    List<Booking> getUserBookings(Integer userId);
}
