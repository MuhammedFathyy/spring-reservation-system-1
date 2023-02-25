package com.gradproject.yourspace.entity;

import com.sun.istack.NotNull;
import javax.persistence.*;

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

        public User() {
        }

        public User(String email, String firstName, String lastName,
                    String password, String phoneNo, String address,
                    String birthDate, String bio, int points,
                    String picture) {
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

        @Override
        public String toString() {
            return "User{" +
                    "UserId=" + UserId +
                    ", email=" + email +
                    ", firstName=" + firstName +
                    ", lastName=" + lastName +
                    ", password=" + password +
                    ", phoneNo=" + phoneNo +
                    ", address=" + address +
                    ", birthDate=" + birthDate +
                    ", bio=" + bio +
                    ", points=" + points +
                    '}';
        }
}
