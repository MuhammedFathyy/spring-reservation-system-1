
package com.gradproject.yourspace.dto;
 import com.fasterxml.jackson.annotation.JsonFormat;

 import javax.validation.constraints.NotNull;
 import java.util.Date;

public class UserDTO {


    @NotNull
    private int userId;

    @NotNull
    private String email;

    @NotNull
    private String firstName;


    @NotNull
    private String lastName;

    @NotNull
    private String mobileNo;

    @NotNull
    private String address;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date birthDate;

    @NotNull
    private String bio;

    @NotNull
    private int points;


    public UserDTO() {
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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


}