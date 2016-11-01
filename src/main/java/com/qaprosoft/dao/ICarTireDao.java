package com.qaprosoft.dao;
import java.util.List;
import com.qaprosoft.models.CarTire;

public interface ICarTireDao {

    public void insertCarTire(CarTire carTire);
	public List<CarTire> getAllCarTires();
	public void insertCarType(String carType);

}
