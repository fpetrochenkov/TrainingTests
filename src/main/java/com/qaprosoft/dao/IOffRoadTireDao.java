package com.qaprosoft.dao;

import java.util.List;

import com.qaprosoft.models.OffRoadTire;

public interface IOffRoadTireDao {

    public void insertOffRoadTire(OffRoadTire offRoadTire);
	public List<OffRoadTire> getAllOffRoadTires();
	public void insertCarType(String carType);
}
