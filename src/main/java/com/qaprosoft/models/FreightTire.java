package com.qaprosoft.models;

public  class FreightTire extends Tire{
	
	private String axis;
	
	public FreightTire () {}

	public FreightTire(String name, String price, String diameter, String width, String height, String type) {
		super(name, price, diameter, width, height, type);
	}

	public String getAxis() {
		return axis;
	}

	public void setAxis(String axis) {
		this.axis = axis;
	}

}
