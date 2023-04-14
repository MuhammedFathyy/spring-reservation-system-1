
package com.gradproject.yourspace.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "space")

public class Space {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "space_id")
	private int spaceId;

	@NotNull
	@Column(name = "address")
	private String address;
	@NotNull
	@Column(name = "district")
	private String district;
	@Column(name = "images")
	private String images;
	@Column(name = "room_numbers")
	private int roomNumbers;

	@Column(name = "description")
	private String description;
	@NotNull
	@Column(name = "name",unique = true)
	private String name;
	@Column(name = "contact_No")
	private String contactNumber;
	@Column(name = "min_price")
	private double minPrice;
	@Column(name = "max_price")
	private double maxPrice;
	@Column(name = "min_opening_hours")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
	private Time startTime;
	@Column(name = "max_opening_hours")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
	private Time endTime;
	@Column(name = "offers_drinks")
	private boolean drinks;
	@Column(name = "owner")
	private String owner;
	@Column(name = "outdoors")
	private boolean outdoors;

	@Column(name="rating_average")
	private double ratingAverage;
	@OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private List<Room> rooms;


	@OneToMany(mappedBy = "space",cascade ={CascadeType.PERSIST,CascadeType.REMOVE})
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private List<Rating> ratings;



	public Space() {

	}

	public Space(String address, String district,  String images, int roomNumbers, String description, String name, String contactNumber, double minPrice, double maxPrice, Time startTime, Time endTime, boolean drinks, String owner, boolean outdoors, double ratingAverage, List<Room> rooms, List<Rating> ratings) {
		this.address = address;
		this.district = district;
		this.images = images;
		this.roomNumbers = roomNumbers;
		this.description = description;
		this.name = name;
		this.contactNumber = contactNumber;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.startTime = startTime;
		this.endTime = endTime;
		this.drinks = drinks;
		this.owner = owner;
		this.outdoors = outdoors;
		this.ratingAverage = ratingAverage;
		this.rooms = rooms;
		this.ratings = ratings;
	}

	public int getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}



	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getRoomNumbers() {
		return roomNumbers;
	}

	public void setRoomNumbers(int roomNumbers) {
		this.roomNumbers = roomNumbers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public boolean isDrinks() {
		return drinks;
	}

	public void setDrinks(boolean drinks) {
		this.drinks = drinks;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isOutdoors() {
		return outdoors;
	}

	public void setOutdoors(boolean outdoors) {
		this.outdoors = outdoors;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}


	public void setRatingAverage() {

		double total=0;

		for(int i=0; i< ratings.size();i++){
			total+= ratings.get(i).getRating();
		}

		total= total/ratings.size();
		this.ratingAverage=total;


	}
	public double getRatingAverage() {
		return ratingAverage;
	}


	public void addRoom(Room room){
		if (rooms==null){
			rooms= new ArrayList<>();
		}
		else rooms.add(room);
	}

	public void addRating(Rating rating){
		if(this.ratings==null){
			this.ratings=new ArrayList<>();
		}
		else ratings.add(rating);
	}
}
