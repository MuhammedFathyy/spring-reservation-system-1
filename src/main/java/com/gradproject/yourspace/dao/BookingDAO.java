package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Integer> {


}
