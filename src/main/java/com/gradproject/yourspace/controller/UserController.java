package com.gradproject.yourspace.controller;


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

    @PatchMapping("{userId}")
    public void updateUser(@PathVariable int userId, @RequestBody HashMap<String , Object> fields)
    {
        User user = userService.getUser(userId);
        //you can check for this user if it is existing or not
        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(User.class, key);
            field.setAccessible(true);
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            boolean normalParameter = true;

            try {
                int points = Integer.parseInt(value.toString());
                ReflectionUtils.setField(field , user , points);
                normalParameter = false;

            }catch (NumberFormatException exc){
                try{
                    Date date = dateFormat.parse((String)value);
                    ReflectionUtils.setField(field , user , date);
                    normalParameter = false;
                }catch ( ParseException e) {}

            if(normalParameter){
                ReflectionUtils.setField(field , user , value);
            }
            }
        });
        userService.saveUser(user);

    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable int userId)
    {
        userService.deleteUser(userId);
    }



}
