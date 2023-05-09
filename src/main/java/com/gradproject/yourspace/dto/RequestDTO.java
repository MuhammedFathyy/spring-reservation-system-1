package com.gradproject.yourspace.dto;

import javax.validation.constraints.NotNull;

public class RequestDTO {
    private int requestId;
    @NotNull
    private String name;
    @NotNull
    private String status = "Pending";
    @NotNull
    private String address;
    @NotNull
    private int noOfRooms;
    @NotNull
    private int userId;
    

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
