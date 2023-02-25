package com.gradproject.yourspace.controller;


import com.gradproject.yourspace.entity.User;
import com.gradproject.yourspace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getUsers(){
        List<User> users = userService.getUsers();
        return users;
    };

    @GetMapping("{userid}")
    public User getUser(@PathVariable int userid){
        User user = userService.getUser(userid);
        if(user == null){
            throw new RuntimeException("There is no user with this id");
        }
        return user;
    }

    @PostMapping()
    public void saveUser(@RequestBody User user){
        user.setUserId(0);
        userService.saveUser(user);
    }

    @PutMapping()
    public void updateUser(@RequestBody User user)
    {
        userService.saveUser(user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable int userId)
    {
        userService.deleteUser(userId);
    }



}
