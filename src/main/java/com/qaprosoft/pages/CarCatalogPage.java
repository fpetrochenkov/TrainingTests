package com.qaprosoft.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CarCatalogPage extends AbstractPage {
	
	@FindBy(xpath = "//div[@class='listing-item-title']//a")
	private List<ExtendedWebElement> cars;

	public CarCatalogPage(WebDriver driver) {
		super(driver);
	}
	
	public void printCars() {
		for(ExtendedWebElement car: cars) {
			LOGGER.info(car.getText());
		}
	}
	
	public String readCarTitle(String expected) {		
		for(ExtendedWebElement car: cars) {
			assertElementPresent(car);
			if(car.getText().contains(expected)){
			return expected;
			}
		}
		throw new RuntimeException("Unable to get car title!");
	}

}
