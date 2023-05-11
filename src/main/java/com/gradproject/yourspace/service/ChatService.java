package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.ChatChannelDAO;
import com.gradproject.yourspace.dao.ChatMessageDAO;
import com.gradproject.yourspace.dto.ChatChannelInitializationDTO;
import com.gradproject.yourspace.dto.ChatMessageDTO;
import com.gradproject.yourspace.dto.NotificationDTO;
import com.gradproject.yourspace.entity.ChatMessage;
import com.gradproject.yourspace.entity.ChatChannel;
import com.gradproject.yourspace.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ChatService {
    private ModelMapper modelMapper;

    private ChatChannelDAO chatChannelDAO;

    private ChatMessageDAO chatMessageDAO;

    private UserService userService;

    private final int MAX_PAGABLE_CHAT_MESSAGES = 100;

    @Autowired
    public ChatService(
            ModelMapper modelMapper,
            ChatChannelDAO chatChannelDAO,
            ChatMessageDAO chatMessageDAO,
            UserService userService) {
        this.modelMapper = modelMapper;
        this.chatChannelDAO = chatChannelDAO;
        this.chatMessageDAO = chatMessageDAO;
        this.userService = userService;
    }

    private String getExistingChannel(ChatChannelInitializationDTO chatChannelInitializationDTO) {
        List<ChatChannel> channel = chatChannelDAO
                .findExistingChannel(
                        chatChannelInitializationDTO.getUserIdOne(),
                        chatChannelInitializationDTO.getUserIdTwo()
                );

        return (channel != null && !channel.isEmpty()) ? channel.get(0).getUuid() : null;
    }

    private String newChatSession(ChatChannelInitializationDTO chatChannelInitializationDTO)
            throws BeansException{
        ChatChannel channel = new ChatChannel(
                userService.getUser(chatChannelInitializationDTO.getUserIdOne()),
                userService.getUser(chatChannelInitializationDTO.getUserIdTwo())
        );

        chatChannelDAO.save(channel);

        return channel.getUuid();
    }

    public String establishChatSession(ChatChannelInitializationDTO chatChannelInitializationDTO)
            throws BeansException{
        String uuid = getExistingChannel(chatChannelInitializationDTO);

        // If channel doesn't already exist, create a new one
        return (uuid != null) ? uuid : newChatSession(chatChannelInitializationDTO);
    }

    public void submitMessage(ChatMessageDTO chatMessageDTO)
            throws BeansException {
        ChatMessage chatMessage = modelMapper.map(chatMessageDTO, ChatMessage.class);

        chatMessageDAO.save(chatMessage);

        User fromUser = userService.getUser(chatMessage.getAuthorUser().getUserId());
        User recipientUser = userService.getUser(chatMessage.getRecipientUser().getUserId());

        userService.notifyUser(recipientUser,
                new NotificationDTO(
                        "ChatMessageNotification",
                        fromUser.getFirstName() + " has sent you a message",
                        chatMessage.getAuthorUser().getUserId()
                )
        );
    }

    public List<ChatMessage> getExistingChatMessages(String channelUuid) {
        ChatChannel channel = chatChannelDAO.getChannelDetails(channelUuid);

       return
                chatMessageDAO.getExistingChatMessages(
                        channel.getUserOne().getUserId(),
                        channel.getUserTwo().getUserId()
                        //new PageRequest(0, MAX_PAGABLE_CHAT_MESSAGES) ---> paging
                );

    }
}