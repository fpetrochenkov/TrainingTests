package com.qaprosoft.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.pages.TiresCatalogPage;

public class TabsFiller extends AbstractUIObject {

	public TabsFiller(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div[2]/div[1]/div/div[1]/div/div[1]/a")
	private ExtendedWebElement car;

	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div[2]/div[1]/div/div[1]/div/div[2]/a")
	private ExtendedWebElement tyre;

	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div[2]/div[1]/div/div[1]/div/div[3]/a")
	private ExtendedWebElement offRoad;

	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div[2]/div[1]/div/div[1]/div/div[4]/a")
	private ExtendedWebElement freight;

	@FindBy(xpath = "//button[@class='button button-primary button-block js-submit-car-filter']")
	private ExtendedWebElement search;
	
	@FindBy(xpath = "//h4[@class='tyre-catalog-title']")
	private List<ExtendedWebElement> carTypes;
	
	public TiresCatalogPage selectTires(String carType) {
//		if (car.getText().equalsIgnoreCase(carType)) {
//			click(car);
//		}
//		if(tyre.getText().equalsIgnoreCase(carType)) {
//			click(tyre);
//		}
//		if(offRoad.getText().equalsIgnoreCase(carType)) {
//			click(offRoad);			
//		}
//		if(freight.getText().equalsIgnoreCase(carType)) {
//			click(freight);
//		}
		
		for(ExtendedWebElement cartype: carTypes) {
			if(cartype.getText().equalsIgnoreCase(carType) ) {
				click(cartype);
			}
			if(cartype.getText().equalsIgnoreCase(carType) ) {
				click(cartype);
			}
			if(cartype.getText().equalsIgnoreCase(carType) ) {
				click(cartype);
			}
			if(cartype.getText().equalsIgnoreCase(carType)) {
				click(cartype);
			}
		}
		return new TiresCatalogPage(driver);
	}

}
