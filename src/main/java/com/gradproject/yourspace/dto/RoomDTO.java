package com.gradproject.yourspace.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class RoomDTO {

    private Integer id;

    @NotNull
    private Integer number;

    @NotNull
    private String name;

    @NotNull
    private String activity;

    @NotNull
    private String type;

    @NotNull
    private float price;

    @NotNull
    private Integer spaceId;

    private List<Integer> imageId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public List<Integer> getImageId() {
        return imageId;
    }

    public void setImageId(List<Integer> imageId) {
        this.imageId = imageId;
    }

}
