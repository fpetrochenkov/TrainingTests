package com.qaprosoft.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.components.CatalogMenu;
import com.qaprosoft.components.TabsFiller;

public class TireModelPage extends AbstractPage {
	
	@FindBy(xpath = "//div[@class='tyre-catalog-lists']//a[contains(text(),'зимние')]")
	private CatalogMenu tireMenu;
	
	@FindBy(xpath="//div[@class='tabsfilter']")
	private TabsFiller tabsFiller;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div[2]/div[1]/div/div[1]/div/div[1]/a")
	private ExtendedWebElement car;

	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div[2]/div[1]/div/div[1]/div/div[2]/a")
	private ExtendedWebElement tyre;

	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div[2]/div[1]/div/div[1]/div/div[3]/a")
	private ExtendedWebElement offRoad;

	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div[2]/div[1]/div/div[1]/div/div[4]/a")
	private ExtendedWebElement freight;
	
	public TireModelPage(WebDriver driver) {
		super(driver);
	}
	
	public CatalogMenu getCatalogMenu() {
		return tireMenu;
	}
	
	public TabsFiller getTabsFiller() {
		return tabsFiller;
	}
	
	public TiresCatalogPage selectTires(String carType) {
		if(carType.equals("Легковые")) {click(car);}
		if(carType.equals("Легкогрузовые")) {click(tyre);}
		if(carType.equals("Внедорожные")) {click(offRoad);}
		if(carType.equals("Грузовые")) {click(freight);}		
		return new TiresCatalogPage(driver);
	}
	

}
