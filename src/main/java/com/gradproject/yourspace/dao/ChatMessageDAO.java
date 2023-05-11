package com.gradproject.yourspace.dao;


import java.util.List;
import javax.transaction.Transactional;

import com.gradproject.yourspace.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

    @Transactional
    @Repository
    public interface ChatMessageDAO extends JpaRepository<ChatMessage, String> {
        @Query(" FROM"
                + "    ChatMessage m"
                + "  WHERE"
                + "    m.authorUser.userId IN (:userIdOne, :userIdTwo)"
                + "  AND"
                + "    m.recipientUser.userId IN (:userIdOne, :userIdTwo)"
                + "  ORDER BY"
                + "    m.timeSent"
                + "  DESC")
        public List<ChatMessage> getExistingChatMessages(
                @Param("userIdOne") long userIdOne, @Param("userIdTwo") long userIdTwo);
    }