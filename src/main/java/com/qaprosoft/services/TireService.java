package com.qaprosoft.services;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.models.CarTire;
import com.qaprosoft.pages.TiresCatalogPage;

public class TireService extends DriverHelper{
	
	TiresCatalogPage tireCatalog = new TiresCatalogPage(getDriver());
	
	public List<CarTire> fillList() {
		List<CarTire> tires = new ArrayList<>();		
		for(int i = 0; i<tireCatalog.getTireTitles().size(); i++) {		
			CarTire cartire = new CarTire() {};
			cartire.setName(tireCatalog.getTireTitles().get(i));
			cartire.setPrice(tireCatalog.getTirePrices().get(i));
			cartire.setType(tireCatalog.getType());
			cartire.setDiameter(tireCatalog.getDiameter());
			cartire.setWidth(tireCatalog.getWidth());
			cartire.setHeight(tireCatalog.getHeight());
			tires.add(cartire);
		}
		return tires;
	}
	
	

}
