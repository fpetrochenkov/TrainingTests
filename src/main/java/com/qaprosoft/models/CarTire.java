package com.qaprosoft.models;

public abstract class CarTire extends Tire {
	
	public CarTire () {}

	public CarTire(String name, String price, String diameter, String width, String height, String type) {
		super(name, price, diameter, width, height, diameter);
	}

	
	
}