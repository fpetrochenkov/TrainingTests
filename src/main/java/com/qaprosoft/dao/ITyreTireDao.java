package com.qaprosoft.dao;

import java.util.List;
import com.qaprosoft.models.TyreTire;

public interface ITyreTireDao {

    public void insertTyreTire(TyreTire tyreTire);
	public List<TyreTire> getAllTyreTires();
	public void insertCarType(String carType);
}
