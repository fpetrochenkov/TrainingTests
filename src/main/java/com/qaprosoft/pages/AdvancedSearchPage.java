package com.qaprosoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class AdvancedSearchPage extends AbstractPage {
	
	@FindBy(id = "brand_id")
	private ExtendedWebElement brand;
	
	@FindBy(id = "model_id")
	private ExtendedWebElement model;
	
	@FindBy(xpath = "//input[@class='button button-primary']")
	private ExtendedWebElement searchButton;
	
	public AdvancedSearchPage(WebDriver driver) {
		super(driver);
		setPageURL(R.TESTDATA.get("url_advanceSearch_page"));
	}
	
	public CarCatalogPage searchModel(String carBrand, String carModel) {
		brand.select(carBrand);
		model.select(carModel);
		searchButton.click();
		return new CarCatalogPage(driver);
	}

}
