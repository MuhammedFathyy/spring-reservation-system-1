package com.gradproject.yourspace.controller;


import com.gradproject.yourspace.dto.BookingDTO;
import com.gradproject.yourspace.dto.UserDTO;
import com.gradproject.yourspace.entity.User;
import com.gradproject.yourspace.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping()
    public List<UserDTO> getUsers()
    {
        List<User> users = userService.getUsers();
        return users
                .stream()
                .map(user -> modelMapper.map(user , UserDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("{userid}")
    public UserDTO getUser(@PathVariable int userid)
    {
        User user = userService.getUser(userid);
        return modelMapper.map(user , UserDTO.class);
    }


    @PostMapping()
    public void saveUser(@RequestBody User user)
    {
        userService.saveUser(user);
    }

    @PatchMapping("{userId}")
    public void updateUser(@PathVariable int userId,
                           @RequestBody HashMap<String, Object> fields) {
        userService.updateUser(userId, fields);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("{userId}/bookings")
    public List<BookingDTO> getUserBookings(@PathVariable Integer userId) {
        return userService.getUserBookings(userId)
                .stream()
                .map(booking -> modelMapper.map(booking , BookingDTO.class))
                .collect(Collectors.toList());
    }
}
