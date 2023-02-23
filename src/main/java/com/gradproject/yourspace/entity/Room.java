package com.gradproject.yourspace.entity;

import javax.persistence.*;
import com.gradproject.yourspace.entity.Space;

@Entity
@Table(name = "room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private int roomId;

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
	
	@Column(name = "image")
	private String image;

	@ManyToOne(cascade = { CascadeType.ALL})
	@JoinColumn(name = "space_Id")
	private Space space;

	public Room() {
		super();
	}


	public Room(int number, String name, String activity, String type, float price, String image, Space space) {
		this.number = number;
		this.name = name;
		this.activity = activity;
		this.type = type;
		this.price = price;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	public Space getSpace() {
		return space;
}

   public void setSpace(Space space) {
 	this.space = space;
	}

//	@Override
//	public String toString() {
//		return "Room [roomId=" + roomId + ", number=" + number + ", name=" + name + ", activity=" + activity + ", type="
//				+ type + ", price=" + price + ", image=" + image + "]";
//	}
	

	
}
