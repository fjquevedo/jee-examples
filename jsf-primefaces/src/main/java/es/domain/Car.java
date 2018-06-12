package es.domain;

public class Car {
		
	private String id;
	private int year;
	private String color;
	private String brand;
	private int price;
	private boolean soldState;
	
	public Car(String id, String brand, int year, String color,  int price, boolean soldState) {
		super();
		this.id = id;
		this.year = year;
		this.color = color;
		this.brand = brand;
		this.price = price;
		this.soldState = soldState;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the soldState
	 */
	public boolean isSoldState() {
		return soldState;
	}
	/**
	 * @param soldState the soldState to set
	 */
	public void setSoldState(boolean soldState) {
		this.soldState = soldState;
	}
	
	

}
