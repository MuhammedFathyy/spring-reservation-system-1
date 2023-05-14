package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.ChatMessageDAO;
import com.gradproject.yourspace.entity.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageDAO chatMessageDAO;

    public ChatMessageService(ChatMessageDAO chatMessageDAO) {
        this.chatMessageDAO = chatMessageDAO;
    }

    @Transactional
    public void addMessage(ChatMessage message) {
        message.setId(0);
        chatMessageDAO.save(message);

    }
}
