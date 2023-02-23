package com.gradproject.yourspace.dao.Space;

import com.gradproject.yourspace.entity.Space;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SpaceDaoImpl implements  SpaceDao{

    @Autowired
    EntityManager entityManager;
    SpaceDaoImpl(EntityManager entityManager1){
        this.entityManager=entityManager1;
    }
    @Override
    public void save(Space space) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(space);
    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query=session.createQuery("delete from"+ Space.class.getName()+"where spaceId:=id");

    }

    @Override
    public Space getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Space.class,id);
    }

    @Override
    public List<Space> getSpaces() {
        Session session = entityManager.unwrap(Session.class);
        Query<Space> query= session.createQuery("from"+Space.class.getName());
        return query.getResultList();
    }
}
