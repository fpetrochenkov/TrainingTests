package com.qaprosoft.services;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.models.Car;
import com.qaprosoft.models.Truck;
import com.qaprosoft.models.Suv;
import com.qaprosoft.models.LightTruck;
import com.qaprosoft.pages.TiresCatalogPage;

public class TireService extends DriverHelper {

	TiresCatalogPage tireCatalog = new TiresCatalogPage(getDriver());

	public List<Car> fillCarList() {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < tireCatalog.getTireTitles().size(); i++) {
			Car car = new Car();
			car.setName(tireCatalog.getTireTitles().get(i));
			car.setPrice(tireCatalog.getTirePrices().get(i));
			car.setType(tireCatalog.getType());
			car.setDiameter(tireCatalog.getDiameter());
			car.setWidth(tireCatalog.getWidth());
			car.setHeight(tireCatalog.getHeight());
			cars.add(car);
		}
		return cars;
	}

	public List<LightTruck> fillLightTruckList() {
		List<LightTruck> lightTrucks = new ArrayList<>();
		for (int i = 0; i < tireCatalog.getTireTitles().size(); i++) {
			LightTruck lightTruck = new LightTruck();
			lightTruck.setName(tireCatalog.getTireTitles().get(i));
			lightTruck.setPrice(tireCatalog.getTirePrices().get(i));
			lightTruck.setType(tireCatalog.getType());
			lightTruck.setDiameter(tireCatalog.getDiameter());
			lightTruck.setWidth(tireCatalog.getWidth());
			lightTruck.setHeight(tireCatalog.getHeight());
			lightTrucks.add(lightTruck);
		}
		return lightTrucks;
	}

	public List<Suv> fillSuvList() {
		List<Suv> suves = new ArrayList<>();
		for (int i = 0; i < tireCatalog.getTireTitles().size(); i++) {
			Suv suv = new Suv();
			suv.setName(tireCatalog.getTireTitles().get(i));
			suv.setPrice(tireCatalog.getTirePrices().get(i));
			suv.setType(tireCatalog.getType());
			suv.setDiameter(tireCatalog.getDiameter());
			suv.setWidth(tireCatalog.getWidth());
			suv.setHeight(tireCatalog.getHeight());
			suves.add(suv);
		}
		return suves;
	}

	public List<Truck> fillTruckList() {
		List<Truck> trucks = new ArrayList<>();
		for (int i = 0; i < tireCatalog.getTireTitles().size(); i++) {
			Truck truck = new Truck();
			truck.setName(tireCatalog.getTireTitles().get(i));
			truck.setPrice(tireCatalog.getTirePrices().get(i));
			truck.setType(tireCatalog.getType().substring(0, 13));
			truck.setDiameter(tireCatalog.getDiameter());
			truck.setWidth(tireCatalog.getWidth());
			truck.setHeight(tireCatalog.getHeight());
			trucks.add(truck);
		}
		return trucks;
	}
}
