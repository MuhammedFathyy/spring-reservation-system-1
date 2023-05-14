package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.ChatChannelDAO;
import com.gradproject.yourspace.dao.UserDAO;
import com.gradproject.yourspace.entity.ChatChannel;
import com.gradproject.yourspace.entity.ChatMessage;
import com.gradproject.yourspace.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChatChannelService {
    @Autowired
    private ChatChannelDAO chatChannelDAO;


    @Transactional
    public ChatChannel getChannel(ChatMessage message) {
        User sender = message.getAuthorUser();
        User reciever = message.getRecipientUser();
        ChatChannel channel = chatChannelDAO.getChannel(sender.getUserId(), reciever.getUserId());
        if(channel== null){
            ChatChannel newChannel = new ChatChannel( sender,reciever );
            chatChannelDAO.save(newChannel);
            return newChannel;
        }
       return channel;
    }


    @Transactional
    public void save(ChatChannel newchannel) {
        newchannel.setChannelId(0);
        chatChannelDAO.save(newchannel);
    }
}
