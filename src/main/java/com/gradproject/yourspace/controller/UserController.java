package com.gradproject.yourspace.controller;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.gradproject.yourspace.entity.User;
import com.gradproject.yourspace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.text.ParseException;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping()
    public List<User> getUsers(){return userService.getUsers();};


    @GetMapping("{userid}")
    public User getUser(@PathVariable int userid){return userService.getUser(userid);}


    @PostMapping()
    public void saveUser(@RequestBody User user) {userService.saveUser(user);}

    @PatchMapping("{userId}")
    public void updateUser(@PathVariable int userId,
                           @RequestBody HashMap<String , Object> fields)
    {userService.updateUser(userId , fields);}

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable int userId)
    {
        userService.deleteUser(userId);
    }
    
}
