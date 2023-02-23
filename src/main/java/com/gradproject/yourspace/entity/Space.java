package yourspace.database.Entity;

import javax.persistence.*;
import yourspace

@Entity
@Table(name="space")
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="space_id")
    private int spaceId;
    @Column(name="address")
    private String address;
    @Column(name="district")
    private String district;
    @Column(name="rating")
    private float rating;
    @Column (name="images")
    private string images;
    @Column(name="room_numbers")
    private int roomNumbers;
    @Column(name="description")
    private String description;
    @Column(name="name")
    private String name;
    @Column(name="contact_No")
    private  String contactNumber;
    @Column(name="min_price")
    private double minPrice;
    @Column(name="max_price")
    private double maxPrice;
    @Column(name= "min_opening_hours")
    private String startTime;
    @Column(name="max_opening_hours")
    private String endTime;
    @Column(name="offers_drinks")
    private boolean drinks;
    @Column(name="owner")
    private String owner;
    @Column(name="outdoors")
    private boolean outdoors;
    public  Space(){

    }

    public Space(String address, String district, float rating, string images, int roomNumbers, String description, String name, String contactNumber, double minPrice, double maxPrice, String startTime, String endTime, boolean drinks, String owner, boolean outdoors) {
        this.address = address;
        this.district = district;
        this.rating = rating;
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
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setImages(string images) {
        this.images = images;
    }

    public void setRoomNumbers(int roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setDrinks(boolean drinks) {
        this.drinks = drinks;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setOutdoors(boolean outdoors) {
        this.outdoors = outdoors;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public float getRating() {
        return rating;
    }

    public string getImages() {
        return images;
    }

    public int getRoomNumbers() {
        return roomNumbers;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public boolean isDrinks() {
        return drinks;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isOutdoors() {
        return outdoors;
    }

    public void addRoom(Room room){
        if(rooms==null){
            rooms= new ArrayList<>();
        }
        rooms.add(room);
        room.set
    }
}
