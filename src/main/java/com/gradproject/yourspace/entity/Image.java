package com.gradproject.yourspace.entity;


import javax.persistence.*;

@Entity
@Table(name="images")
public class Image {


    public Image( String name,byte[] imageDate, String type) {

        this.imageDate = imageDate;
        this.type = type;
        this.name=name;
    }

    public Image() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "image_id")
    private int imageId;
    @Column(name="image_data",length = 1000)
    @Lob
    private byte[] imageDate;

    @Column(name="type")
    private String type;

    @Column(name="name",unique = true)
    private String name;

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

    public byte[] getImageDate() {
        return imageDate;
    }

    public void setImageDate(byte[] imageDate) {
        this.imageDate = imageDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
