package com.gradproject.yourspace.dao;


import com.gradproject.yourspace.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageDAO extends JpaRepository<ChatMessage,Integer> {


}
