package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Booking;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO{

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Booking> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Booking> query = session.createQuery("from " + Booking.class.getName() + " Order by id" , Booking.class);
        return query.getResultList();
    }

    @Override
    public Booking findById(int bookId) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Booking.class, bookId);
    }

    @Override
    public void saveBooking(Booking booking) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(booking);
    }

    @Override
    public void deleteBooking(int bookingId) {
        Session session = entityManager.unwrap(Session.class);
        Query<Booking> query = session.createQuery("delete from Booking where id=:bookingId", Booking.class);
        query.executeUpdate();
    }
}
