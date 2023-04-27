package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.UserDAO;
import com.gradproject.yourspace.entity.Booking;
import com.gradproject.yourspace.entity.User;


import com.gradproject.yourspace.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.text.ParseException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO usersDAO;

    public UserServiceImpl(UserDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        return usersDAO.findAll();
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return usersDAO.findUserByUserId(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        user.setUserId(0);
        usersDAO.save(user);
    }

    @Transactional
    @Override
    public void updateUser(int userId , HashMap<String , Object> fields)
    {
        User user = usersDAO.findUserByUserId(userId);
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
        usersDAO.save(user);
    }


    @Transactional
    @Override
    public void deleteUser(int id) {
        usersDAO.deleteById(id);
    }

    @Override
    @Transactional
    public List<Booking> getUserBookings(Integer userId) {
        User user = usersDAO.findById(userId).orElse(null);
        if (user == null) throw new BadRequestException("no user found with " +
                "id " + userId.intValue());
        return user.getBookings();
    }
}
