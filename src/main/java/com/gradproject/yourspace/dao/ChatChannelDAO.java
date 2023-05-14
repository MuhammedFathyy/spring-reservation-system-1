package com.gradproject.yourspace.dao;


import com.gradproject.yourspace.entity.ChatChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatChannelDAO  extends JpaRepository<ChatChannel, Integer> {


    @Query(value = " FROM"
            + "    ChatChannel c"
            + "  WHERE"
            + "    c.userOne.userId IN (:senderId, :recieverId) "
            + "  AND"
            + "    c.userTwo.userId IN (:senderId, :recieverId)"
    ,nativeQuery = true)
    public Optional<ChatChannel>getChannel(int senderId, int recieverId);


}
