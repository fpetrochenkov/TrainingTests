package com.qaprosoft.models;

public abstract class FreightTire extends Tire{
	
	public FreightTire () {}

	public FreightTire(String name, String price, String diameter, String width, String height, String type) {
		super(name, price, diameter, width, height, type);
	}

}
