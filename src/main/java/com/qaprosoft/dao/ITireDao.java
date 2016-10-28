package com.qaprosoft.dao;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.models.Tire;

public interface ITireDao {

	public void insertTires(ArrayList<Tire> tires);
    public void insertTire(Tire tire);
	public List<Tire> getAllTires();

}
