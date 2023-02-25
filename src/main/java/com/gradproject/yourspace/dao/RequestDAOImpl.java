package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.dao.RequestDAO;
import com.gradproject.yourspace.entity.Request;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RequestDAOImpl implements RequestDAO {

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Request> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Request> query = session.createQuery("from " + Request.class.getName() , Request.class);
        return query.getResultList();
    }

    @Override
    public Request findById(int requestId) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Request.class, requestId);
    }

    @Override
    public void saveRequest(Request request) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(request);
    }

    @Override
    public void deleteRequest(int requestId) {
        Session session = entityManager.unwrap(Session.class);
        Query<Request> query = session.createQuery("delete from Request where requestId=:id");
        query.setParameter("id", requestId);
        query.executeUpdate();
    }
}
