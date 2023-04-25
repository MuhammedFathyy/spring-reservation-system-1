package com.gradproject.yourspace.dto;

import com.gradproject.yourspace.entity.User;

public class RequestDTO {
    private int requestId;
    private String name;
    private String status = "pending";
    private String address;
    private int noOfRooms;
    private User user;

    public RequestDTO(String name, String status, String address, int noOfRooms, User user) {
        this.name = name;
        this.status = status;
        this.address = address;
        this.noOfRooms = noOfRooms;
        this.user = user;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
