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

	@FindBy(xpath = ".//dt[@class='tabsfilter-type js-tabsfilter-type tabsfilter-item--active']")
	private ExtendedWebElement car;

	@FindBy(xpath = ".//dt[@class='tabsfilter-type js-tabsfilter-type'][contains(text(),'Легкогрузовые')]")
	private ExtendedWebElement tyre;

	@FindBy(xpath = ".//dt[@class='tabsfilter-type js-tabsfilter-type'][contains(text(),'Внедорожные')]")
	private ExtendedWebElement offRoad;

	@FindBy(xpath = ".//dt[@class='tabsfilter-type js-tabsfilter-type'][contains(text(),'Грузовые')]")
	private ExtendedWebElement freight;

	@FindBy(name = "tires_width")
	private List<ExtendedWebElement> widthsTires;

	@FindBy(name = "tires_height")
	private List<ExtendedWebElement> heightsTires;

	@FindBy(name = "landing_diameter")
	private List<ExtendedWebElement> diametersTires;

	@FindBy(xpath = ".//div[@class='av-radiogroup']/label/span/i")
	private List<ExtendedWebElement> types;

	@FindBy(xpath = "//button[@class='button button-primary button-block js-submit-car-filter']")
	private ExtendedWebElement searchButton;

	public TiresCatalogPage selectTires(int width,int height, int diameter, String carType, String type) {
		List<ExtendedWebElement> carTypes = new ArrayList<>();
		carTypes.add(car);
		carTypes.add(tyre);
		carTypes.add(offRoad);
		carTypes.add(freight);
		for (ExtendedWebElement carTyp : carTypes) {
			if (carTyp.getText().equalsIgnoreCase(carType)) {
				click(carTyp);
				for (ExtendedWebElement widthTires : widthsTires) {
					select(widthTires, width);
				}
				for (ExtendedWebElement heightTires : heightsTires) {
					select(heightTires, height);
				}
				for (ExtendedWebElement diameterTires : diametersTires) {
					select(diameterTires, diameter);
				}
				for (ExtendedWebElement typ : types) {
					if (typ.getText().equalsIgnoreCase(type)) {
						click(typ);
					}
				}
				click(searchButton);
			}

		}

		return new TiresCatalogPage(driver);
	}

}
