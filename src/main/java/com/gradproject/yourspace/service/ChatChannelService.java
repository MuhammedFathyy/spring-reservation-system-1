package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.ChatChannelDAO;
import com.gradproject.yourspace.entity.ChatChannel;
import com.gradproject.yourspace.entity.ChatMessage;
import com.gradproject.yourspace.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ChatChannelService {
    @Autowired
    private ChatChannelDAO chatChannelDAO;


    @Transactional
    public void saveChannel(ChatChannel channel) {
        chatChannelDAO.save(channel);
    }


    @Transactional
    public ChatChannel getChannel(ChatMessage message) {
        User sender = message.getAuthorUser();
        User receiver = message.getRecipientUser();
        //need to find the sender and reciever with id to get firstname of both
        Optional<ChatChannel> optionalChatChannel =chatChannelDAO.getChannel(sender.getUserId(), receiver.getUserId());


        if (!optionalChatChannel.isPresent()) {

            ChatChannel newChannel = new ChatChannel();
            newChannel.setUserOne(message.getAuthorUser());
            newChannel.setUserTwo(message.getRecipientUser());
            saveChannel(newChannel);
            return newChannel;

        } else {

            return optionalChatChannel.get();
        }


    }
}


