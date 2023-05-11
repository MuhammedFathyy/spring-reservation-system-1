package com.gradproject.yourspace.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.gradproject.yourspace.dto.AllSpacesDTO;
import com.gradproject.yourspace.dto.ChatChannelInitializationDTO;
import com.gradproject.yourspace.dto.ChatMessageDTO;
import com.gradproject.yourspace.dto.EstablishedChatChannelDTO;
import com.gradproject.yourspace.entity.ChatMessage;
import com.gradproject.yourspace.entity.User;
import com.gradproject.yourspace.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatChannelController  {
    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @MessageMapping("/private.chat.{channelId}")
    @SendTo("/topic/private.chat.{channelId}")
    public ChatMessageDTO chatMessage(@DestinationVariable String channelId, ChatMessageDTO message)
            throws BeansException {
        chatService.submitMessage(message);

        return message;
    }

    @RequestMapping(value="/api/private-chat/channel", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<EstablishedChatChannelDTO> establishChatChannel(@RequestBody ChatChannelInitializationDTO chatChannelInitialization)
    {
        String channelUuid = chatService.establishChatSession(chatChannelInitialization);
        User userOne = userService.getUser(chatChannelInitialization.getUserIdOne());
        User userTwo = userService.getUser(chatChannelInitialization.getUserIdTwo());

        EstablishedChatChannelDTO establishedChatChannel = new EstablishedChatChannelDTO(
                channelUuid,
                userOne.getFirstName();
                userTwo.getFirstName();
        );

        return ResponseEntity.ok(establishedChatChannel);
    }

    @RequestMapping(value="/api/private-chat/channel/{channelUuid}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity< List<ChatMessageDTO>> getExistingChatMessages(@PathVariable("channelUuid") String channelUuid) {
        return chatService.getExistingChatMessages(channelUuid)
                .stream().map(chatMessage->modelMapper.map(chatMessage, ChatMessageDTO.class))
                .collect(Collectors.toList());


        return ResponseEntity.ok(messages);
    }
}