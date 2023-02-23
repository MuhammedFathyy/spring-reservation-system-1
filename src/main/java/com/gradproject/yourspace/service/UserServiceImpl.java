package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.UsersDAO;
import com.gradproject.yourspace.entity.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersDAO usersDAO;

    @Transactional
    @Override
    public List<User> getUsers() {
        return usersDAO.getUsers();
    }
    @Transactional
    @Override
    public User getUser(int id) {
        return usersDAO.getUser(id);
    }
    @Transactional
    @Override
    public void saveUser(int id) { usersDAO.saveUser(id);}
    @Transactional
    @Override
    public void deleteUser(int id) { usersDAO.deleteUser(id);}
}
