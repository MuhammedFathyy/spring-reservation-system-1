package com.gradproject.yourspace.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="chatChannel")
public class ChatChannel {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="channel_id")
    private int ChannelId;

    @OneToOne
    @JoinColumn(name = "userIdOne")
    private User userOne;

    @OneToOne
    @JoinColumn(name = "userIdTwo")
    private User userTwo;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ChatMessage> messages;

    public ChatChannel(User userOne, User userTwo, List<ChatMessage> messages) {
        this.userOne = userOne;
        this.userTwo = userTwo;
        this.messages = messages;
    }


    public ChatChannel() {}

    public ChatChannel(User sender, User reciever) {
        this.userOne = sender;
        this.userTwo = reciever;
    }

    public void setUserTwo(User user) {
        this.userTwo = user;
    }

    public void setUserOne(User user) {
        this.userOne = user;
    }

    public User getUserOne() {
        return this.userOne;
    }

    public User getUserTwo() {
        return this.userTwo;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public int getChannelId() {
        return ChannelId;
    }

    public void setChannelId(int channelId) {
        ChannelId = channelId;
    }


}