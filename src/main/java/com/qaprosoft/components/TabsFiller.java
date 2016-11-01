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

	// @FindBy(xpath = "//*[@id='tires-car-filter-form']/div/div[1]/select")
	// private ExtendedWebElement width;

	// @FindBy(linkText = "Высота")
	// private ExtendedWebElement height;
	//
	// @FindBy(linkText = "Диаметр")
	// private ExtendedWebElement diameter;

	@FindBy(xpath = "//button[@class='button button-primary button-block js-submit-car-filter']")
	private ExtendedWebElement search;

	// @FindBy(linkText = "Летние")

	public TiresCatalogPage selectTires(String carType) {
		if (car.getText().equalsIgnoreCase(carType)) {
			click(car);
		}
		click(search);
		return new TiresCatalogPage(driver);
	}

}
