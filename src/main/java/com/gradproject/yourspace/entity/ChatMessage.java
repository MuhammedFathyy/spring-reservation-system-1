package com.gradproject.yourspace.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import java.util.Date;

@Entity
@Table(name="chatMessage")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "authorUserId")
    private User authorUser;

    @OneToOne
    @JoinColumn(name = "recipientUserId")
    private User recipientUser;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private ChatChannel channel;
    private Date timeSent;

    @NotNull
    private String contents;



    public ChatMessage() {}

    public ChatMessage(User authorUser, User recipientUser, ChatChannel channel, Date timeSent, String contents) {
        this.authorUser = authorUser;
        this.recipientUser = recipientUser;
        this.channel = channel;
        this.timeSent = timeSent;
        this.contents = contents;
    }

    public long getId() {
        return this.id;
    }

    public User getAuthorUser() {
        return this.authorUser;
    }

    public User getRecipientUser() {
        return this.recipientUser;
    }

    public void setAuthorUser(User user) {
        this.recipientUser = user;
    }

    public void setRecipientUser(User user) {
        this.authorUser = user;
    }

    public Date getTimeSent() {
        return this.timeSent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChatChannel getChannel() {
        return channel;
    }

    public void setChannel(ChatChannel channel) {
        this.channel = channel;
    }

    public void setTimeSent(Date timeSent) {
        this.timeSent = timeSent;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return this.contents;
    }
}