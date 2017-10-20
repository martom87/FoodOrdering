package model;

public class Course {
	int id;
	String name;
	String cousine;
	double price;

	public Course() {
		super();

	}

	public Course(int id, String name, String cousine, double price) {

		this.id = id;
		this.name = name;
		this.cousine = cousine;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCousine() {
		return cousine;
	}

	public void setCousine(String cousine) {
		this.cousine = cousine;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "[" + id + "] - " + name + " " + "(" + cousine + ")" + " - " + price + " " + "PLN";
	}
}
