package com.gradproject.yourspace.dto;

import javax.validation.constraints.NotNull;

public class ImageDTO {


    @NotNull
    private byte[] imageData;

    public ImageDTO(){

    }



    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }


}
