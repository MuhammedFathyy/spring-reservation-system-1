package com.gradproject.yourspace.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private Integer roomId;

	@Column(name = "number")
	private int number;

	@Column(name = "name")
	private String name;

	@Column(name = "activity")
	private String activity;

	@Column(name = "type")
	private String type;

	@Column(name = "price")
	private float price;


	@ManyToOne
	@JoinColumn(name = "space_id")
	private Space space;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private List<Booking> bookings;


	@OneToMany(mappedBy = "room",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private List<Image> images;

	public Room() {
		super();
	}

	public Room(int number, String name, String activity, String type, float price, List<Image> images, Space space) {
		this.number = number;
		this.name = name;
		this.activity = activity;
		this.type = type;
		this.price = price;
		this.images = images;
		this.space = space;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
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

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public void addBooking(Booking booking) {
		if (bookings == null) bookings = new ArrayList<>();
		bookings.add(booking);
	}

	public void addImages(Image image) {
		if (images == null) images = new ArrayList<>();
		images.add(image);
	}
	public Space getSpace() {
		return space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}

	@Override
	public String toString() {
		return "Room{" +
				"roomId=" + roomId +
				", number=" + number +
				", name='" + name + '\'' +
				", activity='" + activity + '\'' +
				", type='" + type + '\'' +
				", price=" + price +
				", image='" + images + '\'' +
				'}';
	}
}
