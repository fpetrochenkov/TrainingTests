package com.qaprosoft.dao;

import java.util.List;

import com.qaprosoft.models.FreightTire;

public interface IFreightTireDao {

    public void insertFreightTire(FreightTire freightTire);
	public List<FreightTire> getAllFreightTires();
	public void insertCarType(String carType);
}
