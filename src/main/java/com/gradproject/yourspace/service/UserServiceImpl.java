package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.UserDAO;
import com.gradproject.yourspace.dto.UserDTO;
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
    private UserDTO convertEntityToDto(User user){
        UserDTO userDTO= new UserDTO();
        userDTO.setAddress(user.getAddress());
        userDTO.setBio(user.getBio());
        userDTO.setUserId(user.getUserId());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setMobileNo(user.getMobileNo());
        userDTO.setPicture(user.getPicture());
        userDTO.setPoints(userDTO.getPoints());

        return userDTO;
    }

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
    public UserDTO getUser(int id) {
        User user= usersDAO.findUserByUserId(id);
        return this.convertEntityToDto(user);

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
