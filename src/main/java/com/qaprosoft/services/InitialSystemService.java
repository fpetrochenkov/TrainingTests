package com.qaprosoft.services;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.dao.mybatis.CarTireDaoImpl;
import com.qaprosoft.dao.mybatis.FreightTireDaoImpl;
import com.qaprosoft.dao.mybatis.OffRoadTireDaoImpl;
import com.qaprosoft.dao.mybatis.TyreTireDaoImpl;
import com.qaprosoft.models.CarTire;
import com.qaprosoft.models.FreightTire;
import com.qaprosoft.models.OffRoadTire;
import com.qaprosoft.models.TyreTire;
import com.qaprosoft.pages.TiresCatalogPage;

public class InitialSystemService extends DriverHelper {
	
	TiresCatalogPage tireCatalog = new TiresCatalogPage(getDriver());

	public void fillCarTires() {
		String carType = "Легковые";
		List<CarTire> cartires = new ArrayList<>();
		TireService service = new TireService();
		cartires.addAll(service.fillCarTireList());
		CarTireDaoImpl tireDao = new CarTireDaoImpl();
		for(CarTire cartire: cartires) {
			tireDao.insertCarTire(cartire);
		}		
		if(tireCatalog.getCarType().equalsIgnoreCase(carType)) {
		tireDao.insertCarType(tireCatalog.getCarType());
		}
	}
	
	public void fillTyreTires() {
		String carType = "Легкогрузовые";
		List<TyreTire> tyretires = new ArrayList<>();
		TireService service = new TireService();
		tyretires.addAll(service.fillTyreTireList());
		TyreTireDaoImpl tireDao = new TyreTireDaoImpl();
		for(TyreTire tyretire: tyretires) {
			tireDao.insertTyreTire(tyretire);
		}		
		if(tireCatalog.getCarType().equalsIgnoreCase(carType)) {
		tireDao.insertCarType(tireCatalog.getCarType());
		}
	}
	
	public void fillOffRoadTires() {
		String carType = "Внедорожные";
		List<OffRoadTire> offRoadTires = new ArrayList<>();
		TireService service = new TireService();
		offRoadTires.addAll(service.fillOffRoadTireList());
		OffRoadTireDaoImpl tireDao = new OffRoadTireDaoImpl();
		for(OffRoadTire offRoadTire: offRoadTires) {
			tireDao.insertOffRoadTire(offRoadTire);
		}		
		if(tireCatalog.getCarType().equalsIgnoreCase(carType)) {
		tireDao.insertCarType(tireCatalog.getCarType());
		}
	}
	
	public void fillFreightTires() {
		String carType = "Грузовые";
		List<FreightTire> freightTires = new ArrayList<>();
		TireService service = new TireService();
		freightTires.addAll(service.fillFreightTireList());
		FreightTireDaoImpl tireDao = new FreightTireDaoImpl();
		for(FreightTire freightTire: freightTires) {
			tireDao.insertFreightTire(freightTire);
		}		
		if(tireCatalog.getCarType().equalsIgnoreCase(carType)) {
		tireDao.insertCarType(tireCatalog.getCarType());
		}
	}
	
}
