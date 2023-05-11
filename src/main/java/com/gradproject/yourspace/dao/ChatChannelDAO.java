package com.gradproject.yourspace.dao;

import com.gradproject.yourspace.entity.ChatChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

    @Transactional
    @Repository
    public interface ChatChannelDAO extends JpaRepository<ChatChannel, String> {
        @Query(" FROM"
                + "    ChatChannel c"
                + "  WHERE"
                + "    c.userOne.userId IN (:userOneId, :userTwoId) "
                + "  AND"
                + "    c.userTwo.userId IN (:userOneId, :userTwoId)")
        public List<ChatChannel> findExistingChannel(
                @Param("userOneId") long userOneId, @Param("userTwoId") long userTwoId);

        @Query(" SELECT"
                + "    c.uuid"
                + "  FROM"
                + "    ChatChannel c"
                + "  WHERE"
                + "    c.userOne.userId IN (:userIdOne, :userIdTwo)"
                + "  AND"
                + "    c.userTwo.userId IN (:userIdOne, :userIdTwo)")
        public String getChannelUuid(
                @Param("userIdOne") long userIdOne, @Param("userIdTwo") long userIdTwo);

        @Query(" FROM"
                + "    ChatChannel c"
                + "  WHERE"
                + "    c.uuid = :uuid")
        public ChatChannel getChannelDetails(@Param("uuid") String uuid);
    }
}
