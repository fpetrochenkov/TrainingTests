package com.qaprosoft.dao;

import java.util.List;

import com.qaprosoft.models.Suv;

public interface ISuvDao {

    public void insertSuv(Suv suv);
	public List<Suv> getAllSuves();
	public void insertCarType(String carType);
}
