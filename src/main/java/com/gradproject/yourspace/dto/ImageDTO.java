package com.gradproject.yourspace.dto;

import javax.validation.constraints.NotNull;

public class ImageDTO {


    @NotNull
    private byte[] imageData;

    private int spaceId;
    private int roomId;
    public ImageDTO(){

    }

    public ImageDTO(@NotNull byte[] imageData, int spaceId, int roomId) {
        this.imageData = imageData;
        this.spaceId = spaceId;
        this.roomId = roomId;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }


}
