package com.qaprosoft.services;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.dao.mybatis.CarDaoImpl;
import com.qaprosoft.dao.mybatis.LightTruckDaoImpl;
import com.qaprosoft.dao.mybatis.SuvDaoImpl;
import com.qaprosoft.dao.mybatis.TruckDaoImpl;
import com.qaprosoft.models.Car;
import com.qaprosoft.models.Truck;
import com.qaprosoft.models.Suv;
import com.qaprosoft.models.LightTruck;
import com.qaprosoft.pages.TiresCatalogPage;

public class InitialSystemService extends DriverHelper {

	TiresCatalogPage tireCatalog = new TiresCatalogPage(getDriver());

	public void fillCars() {
		String carType = "Легковые";
		List<Car> cars = new ArrayList<>();
		TireService service = new TireService();
		cars.addAll(service.fillCarList());
		CarDaoImpl tireDao = new CarDaoImpl();
		if (tireCatalog.getCarType().equalsIgnoreCase(carType)) {
			tireDao.insertCarType(tireCatalog.getCarType());
		}
		for (Car car : cars) {
			tireDao.insertCar(car);
		}
	}

	public void fillLightTrucks() {
		String carType = "Легкогрузовые";
		List<LightTruck> lightTrucks = new ArrayList<>();
		TireService service = new TireService();
		lightTrucks.addAll(service.fillLightTruckList());
		LightTruckDaoImpl tireDao = new LightTruckDaoImpl();
		if (tireCatalog.getCarType().equalsIgnoreCase(carType)) {
			tireDao.insertCarType(tireCatalog.getCarType());
		}
		for (LightTruck lightTruck : lightTrucks) {
			tireDao.insertLightTruck(lightTruck);
		}		
	}

	public void fillSuves() {
		String carType = "Внедорожные";
		List<Suv> suves = new ArrayList<>();
		TireService service = new TireService();
		suves.addAll(service.fillSuvList());
		SuvDaoImpl tireDao = new SuvDaoImpl();
		if (tireCatalog.getCarType().equalsIgnoreCase(carType)) {
			tireDao.insertCarType(tireCatalog.getCarType());
		}
		for (Suv suv : suves) {
			tireDao.insertSuv(suv);
		}
	}

	public void fillTrucks() {
		String carType = "Грузовые";
		List<Truck> trucks = new ArrayList<>();
		TireService service = new TireService();
		trucks.addAll(service.fillTruckList());
		TruckDaoImpl tireDao = new TruckDaoImpl();
		if (tireCatalog.getCarType().equalsIgnoreCase(carType)) {
			tireDao.insertCarType(tireCatalog.getCarType());
		}
		for (Truck truck : trucks) {
			tireDao.insertTruck(truck);
		}	
	}

}
