package com.gradproject.yourspace.dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.gradproject.yourspace.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImpl implements UsersDAO {
    private EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getUsers()
    {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("from " + User.class.getName() + " order by userId");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public User getUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class , id);
    }

    @Override
    public void saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from " + User.class.getName() + " where userId = :id");
        query.setParameter("id" , id);
        query.executeUpdate();
    }
}
