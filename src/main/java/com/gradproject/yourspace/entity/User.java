package com.gradproject.yourspace.entity;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        @Column(name = "UserID")
        private int UserId;

        @Column(name = "email")
        @NotNull
        private String email;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "password")
        private String password;

        @Column(name = "mobile_no")
        private String phoneNo;

        @Column(name = "address")
        private String address;

        @Column(name = "birthdate")
        private String birthDate;

        @Column(name = "bio")
        private String bio;

        @Column(name = "points")
        private int points;

        @Column(name = "profile_picture")
        private String picture;

        @OneToMany(mappedBy = "user", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
        private List<Request> requests;

        @OneToMany(mappedBy = "user", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
        private List<Booking> bookings;

        public User() {
        }

    public User(int userId, String email, String firstName,
                String lastName, String password, String phoneNo,
                String address, String birthDate, String bio,
                int points, String picture, List<Request> requests,
                List<Booking> bookings) {
        UserId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNo = phoneNo;
        this.address = address;
        this.birthDate = birthDate;
        this.bio = bio;
        this.points = points;
        this.picture = picture;
        this.requests = requests;
        this.bookings = bookings;
    }

    public int getUserId() {
            return UserId;
        }

        public void setUserId(int userId) {
            UserId = userId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    /* Convience Method */
    public void addRequest(Request request) {
        if (this.requests == null) this.requests = new ArrayList<>();
        requests.add(request);
        request.setUser(this);
    }

    public void addBooking(Booking booking) {
        if (bookings == null) bookings = new ArrayList<>();
        bookings.add(booking);
        booking.setUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address='" + address + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", bio='" + bio + '\'' +
                ", points=" + points +
                ", picture='" + picture + '\'' +
                ", requests=" + requests +
                '}';
    }
}
