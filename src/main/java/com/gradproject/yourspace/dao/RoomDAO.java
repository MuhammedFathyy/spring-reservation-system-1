package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RoomDAO {

	private EntityManager entityManager;

	@Autowired
	public RoomDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	public List<Room> getRooms() {
		Session session = entityManager.unwrap(Session.class);
		Query<Room> query = session.createQuery("from " + Room.class.getName() + " order by number", Room.class);
		return query.getResultList();
	}

	public Room getRoom(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Room.class, id);
	}

	public void saveRoom(Room room) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(room);
	}

	public void deleteRoom(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from " + Room.class.getName() +  " where roomId = :id");
		query.setParameter("id",id );
		query.executeUpdate();

	}

}
