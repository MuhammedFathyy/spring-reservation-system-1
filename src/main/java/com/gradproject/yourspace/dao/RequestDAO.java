package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RequestDAO extends JpaRepository<Request, Integer> {
}
