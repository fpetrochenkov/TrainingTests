package com.qaprosoft.services;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.dao.mybatis.CarTireDaoImpl;
import com.qaprosoft.models.CarTire;
import com.qaprosoft.pages.TiresCatalogPage;

public class InitialSystemService extends DriverHelper {
	
	TiresCatalogPage tireCatalog = new TiresCatalogPage(getDriver());

	public void fillTires() {
		String carType = "Легковые";
		List<CarTire> cartires = new ArrayList<>();
		TireService service = new TireService();
		cartires.addAll(service.fillList());
		CarTireDaoImpl tireDao = new CarTireDaoImpl();
		for(CarTire cartire: cartires) {
			tireDao.insertCarTire(cartire);
		}		
		if(tireCatalog.getCarType().equalsIgnoreCase(carType)) {
		tireDao.insertCarType(tireCatalog.getCarType());
		}

	}
	
}
