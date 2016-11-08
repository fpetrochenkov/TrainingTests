package com.qaprosoft.dao;

import java.util.List;

import com.qaprosoft.models.Truck;

public interface ITruckDao {

    public void insertTruck(Truck truck);
	public List<Truck> getAllTrucks();
	public void insertCarType(String carType);
}
