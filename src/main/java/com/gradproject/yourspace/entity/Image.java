package com.gradproject.yourspace.entity;


import javax.persistence.*;

@Entity
@Table(name="images")
public class Image {


    public Image(byte[] imageData, String type, String name, Space space, Room room, User user) {
        this.imageData = imageData;
        this.type = type;
        this.name = name;
        this.space = space;
        this.room = room;
        this.user = user;
    }

    public Image() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "image_id")
    private int imageId;
    @Column(name="image_data",length = 1000)
    @Lob
    private byte[] imageData;

    @Column(name="type")
    private String type;

    @Column(name="name",unique = true)
    private String name;

    @ManyToOne
    @JoinColumn (name="space_id")
    private Space space;
    @ManyToOne
    @JoinColumn (name="room_id")
    private Room room;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    public int getImageId() {
        return imageId;
    }



    public void setImageId(int imageId) {
        this.imageId = imageId;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
