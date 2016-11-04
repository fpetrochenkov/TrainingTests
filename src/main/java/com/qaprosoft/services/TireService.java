package com.qaprosoft.services;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.models.CarTire;
import com.qaprosoft.models.FreightTire;
import com.qaprosoft.models.OffRoadTire;
import com.qaprosoft.models.TyreTire;
import com.qaprosoft.pages.TiresCatalogPage;

public class TireService extends DriverHelper {

	TiresCatalogPage tireCatalog = new TiresCatalogPage(getDriver());

	public List<CarTire> fillCarTireList() {
		List<CarTire> tires = new ArrayList<>();
		for (int i = 0; i < tireCatalog.getTireTitles().size(); i++) {
			CarTire cartire = new CarTire();
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

	public List<TyreTire> fillTyreTireList() {
		List<TyreTire> tires = new ArrayList<>();
		for (int i = 0; i < tireCatalog.getTireTitles().size(); i++) {
			TyreTire tyretire = new TyreTire();
			tyretire.setName(tireCatalog.getTireTitles().get(i));
			tyretire.setPrice(tireCatalog.getTirePrices().get(i));
			tyretire.setType(tireCatalog.getType());
			tyretire.setDiameter(tireCatalog.getDiameter());
			tyretire.setWidth(tireCatalog.getWidth());
			tyretire.setHeight(tireCatalog.getHeight());
			tires.add(tyretire);
		}
		return tires;
	}

	public List<OffRoadTire> fillOffRoadTireList() {
		List<OffRoadTire> tires = new ArrayList<>();
		for (int i = 0; i < tireCatalog.getTireTitles().size(); i++) {
			OffRoadTire offRoadTire = new OffRoadTire();
			offRoadTire.setName(tireCatalog.getTireTitles().get(i));
			offRoadTire.setPrice(tireCatalog.getTirePrices().get(i));
			offRoadTire.setType(tireCatalog.getType());
			offRoadTire.setDiameter(tireCatalog.getDiameter());
			offRoadTire.setWidth(tireCatalog.getWidth());
			offRoadTire.setHeight(tireCatalog.getHeight());
			tires.add(offRoadTire);
		}
		return tires;
	}

	public List<FreightTire> fillFreightTireList() {
		List<FreightTire> tires = new ArrayList<>();
		for (int i = 0; i < tireCatalog.getTireTitles().size(); i++) {
			FreightTire freightTire = new FreightTire();
			freightTire.setName(tireCatalog.getTireTitles().get(i));
			freightTire.setPrice(tireCatalog.getTirePrices().get(i));
			freightTire.setType(tireCatalog.getType().substring(0, 13));
			freightTire.setDiameter(tireCatalog.getDiameter());
			freightTire.setWidth(tireCatalog.getWidth());
			freightTire.setHeight(tireCatalog.getHeight());
			tires.add(freightTire);
		}
		return tires;
	}
}
