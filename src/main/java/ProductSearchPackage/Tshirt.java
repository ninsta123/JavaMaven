package ProductSearchPackage;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tshirt {
	
	@Id
	private String id;
	private String name;
	private String colour;
	private char gender;
	private String size;
	private double price;
	private float rating;
	private char availability;
	
	// Constructor
	public Tshirt() {
		super();
	}
	
	
	// Getter and Setter for all the fields
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getColour() {
		return colour;
	}
	public void setColor(String color) {
		this.colour = color;
	}
	
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public char getAvailability() {
		return availability;
	}
	public void setAvailability(char availability) {
		this.availability = availability;
	}
	
}
