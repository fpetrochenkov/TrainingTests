package com.qaprosoft.dao;

import java.util.List;
import com.qaprosoft.models.LightTruck;

public interface ILightTruckDao {

    public void insertLightTruck(LightTruck lightTruck);
	public List<LightTruck> getAllLightTrucks();
	public void insertCarType(String carType);
}
