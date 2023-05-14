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
        channel.setChannelId(0);
        chatChannelDAO.save(channel);
    }


    @Transactional
    public ChatChannel getChannel(ChatMessage message) {
        User sender = message.getAuthorUser();
        User reciever = message.getRecipientUser();
        Optional<ChatChannel> optionalChatChannel = chatChannelDAO.getChannel(sender.getUserId(), reciever.getUserId());

        if(optionalChatChannel.isPresent()) {
            return optionalChatChannel.get();
        }
        else{
//            ChatChannel newChannel = optionalChatChannel.get();
            ChatChannel newChannel= new ChatChannel();
            newChannel.setUserOne(message.getAuthorUser());
            newChannel.setUserTwo(message.getRecipientUser());
            saveChannel(newChannel);

            return  newChannel;
        }


    }
}


