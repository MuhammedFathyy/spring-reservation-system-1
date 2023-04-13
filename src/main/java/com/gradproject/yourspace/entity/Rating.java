package com.gradproject.yourspace.entity;

import javax.persistence.*;

@Entity
@Table(name="rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rating_Id")
    private int ratingId;

    @Column(name="comment")
   private String comment;

    @Column(name="rating")
    private float rating;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name="space_id",nullable = false)
    private Space space;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name="user_id",nullable = false)
    private User user;



    public Rating() {
    }

    public Rating(String comment, float rating, Space space, User user) {
        this.comment = comment;
        this.rating = rating;
        this.space = space;
        this.user = user;

    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
