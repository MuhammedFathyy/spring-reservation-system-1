package com.gradproject.yourspace.entity;

import io.micrometer.core.annotation.Counted;
import net.bytebuddy.utility.nullability.NeverNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity()
@Table(name = "request")
public class Request {
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @NotNull
    private String status = "pending";

    @Column(name = "address")
    private String address;

    @Column(name = "no_of_rooms")
    @NotNull
    private int noOfRooms;



//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
////    @JoinColumn(name = "user_id")
//    private User user;

    public Request() {
    }

    public Request(int requestId, String name, String status, String address, int noOfRooms) {
        this.requestId = requestId;
        this.name = name;
        this.status = status;
        this.address = address;
        this.noOfRooms = noOfRooms;
//        this.user = user;
    }

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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", noOfRooms=" + noOfRooms +
//                ", user=" + user +
                '}';
    }
}
