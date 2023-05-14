package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.entity.ChatChannel;
import com.gradproject.yourspace.entity.ChatMessage;
import com.gradproject.yourspace.service.ChatChannelService;
import com.gradproject.yourspace.service.ChatMessageService;
import com.gradproject.yourspace.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ChatChannelService chatChannelService;

    @Autowired
    private ChatMessageService chatMessageService;


//    @MessageMapping("/message")
//    @SendTo("/topic/messages")
//    public ChatMessage getMessage(final ChatMessage message) throws InterruptedException {
//        Thread.sleep(1000);
//        notificationService.sendGlobalNotification();
//        return new ChatMessage((message);
//    }

//    @MessageMapping("/private-message")
//    @SendToUser("/topic/private-messages")
//    public ChatMessage getPrivateMessage(final ChatMessage message,
//                                             final Principal principal) throws InterruptedException {
//        Thread.sleep(1000);
//        //notificationService.sendPrivateNotification(principal.getName());
//
//        // open channel if exists and if not create new one
//        ChatChannel channel=chatChannelService.getChannel(message);
//        message.setChannel(channel);
//        chatMessageService.addMessage(message);
//        return message;
//    }


    @PostMapping("/private")
        public ChatMessage getPrivateMessage(@RequestBody ChatMessage message )
    {
//        Thread.sleep(1000);
        //notificationService.sendPrivateNotification(principal.getName());

        // open channel if exists and if not create new one
        ChatChannel channel=chatChannelService.getChannel(message);
        message.setChannel(channel);
        chatMessageService.addMessage(message);
        return message;
    }
}
