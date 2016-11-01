package com.qaprosoft.models;

public abstract class Tire {
	
    private String name;
    private String price;
	private String diameter;
	private String width;
	private String height;
	private String type;

	public Tire() {
	}	

	public Tire(String name, String price, String diameter, String width, String height, String type) {
		this.name = name;
		this.price = price;
		this.diameter = diameter;
		this.width = width;
		this.height = height;
		this.type = type;
	}
	
	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
