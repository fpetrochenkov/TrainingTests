package com.qaprosoft.dao;
import java.util.List;
import com.qaprosoft.models.Car;

public interface ICarDao {

    public void insertCar(Car carTire);
	public List<Car> getAllCars();
	public void insertCarType(String carType);

}
