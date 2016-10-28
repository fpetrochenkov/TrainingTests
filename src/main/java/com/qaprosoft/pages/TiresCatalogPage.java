package com.qaprosoft.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.models.Tire;

public class TiresCatalogPage extends AbstractPage {
	
	@FindBy(xpath = "//a[@class='sorting-item'][contains(text(),'цене за 1 шт.')]")
	private ExtendedWebElement sorting;
	
	@FindBy(xpath = "//div[@class='tyre-listing-about']//a")
	private List<ExtendedWebElement> tireTitles;
	
	@FindBy(xpath = "//div[@class='tyre-listing-price']/h5")
	private List<ExtendedWebElement> tireCosts;
	
	@FindBy(xpath = "//ul[@class='breadcrumbs-list js-breadcrumbs-list setanim']/li[4]//span")
	private ExtendedWebElement tireDiameter;
	
	@FindBy(xpath = "//ul[@class='breadcrumbs-list js-breadcrumbs-list setanim']/li[5]//span")
	private ExtendedWebElement tireParams;
	
	@FindBy(xpath = "//div[@class='tyre-listing-about']//p")
	private List<ExtendedWebElement> tireTypes;
	
	@FindBy(xpath = "//ul[@class='breadcrumbs-list js-breadcrumbs-list setanim']/li[2]//span")
	private ExtendedWebElement tireCarType;

	public TiresCatalogPage(WebDriver driver) {
		super(driver);
	}
	
	public void sortTires() {
		sorting.doubleClick();
	}
	
	public void printTires() {
		for(int i = 0; i<tireTitles.size(); i++) {
			LOGGER.info(tireTitles.get(i).getText() + " " + tireCosts.get(i).getText());
		}
	}
	
	public List<ExtendedWebElement> getTireTitles() {
		return tireTitles;
	}
	
	public List<ExtendedWebElement> getTireCosts() {
		return tireCosts;
	}
	
	public ExtendedWebElement getTireDiameter() {
		return tireDiameter;
	}
	
	public ExtendedWebElement getTireParams() {
		return tireParams;
	}
	
	public List<ExtendedWebElement> getTireTypes() {
		return tireTypes;
	}
	
	public ExtendedWebElement getTireCarType() {
		return tireCarType;
	}
	
	
//	public List<Tire> fillList() {
//		List<Tire> tires = new ArrayList<>();
//		for(int i = 0; i<tireTitles.size(); i++) {
//			Tire tire = new Tire();
//			tire.setName(tireTitles.get(i).getText());
//			tire.setPrice(tireCosts.get(i).getText());
//			tire.setType(tireTypes.get(i).getText());
//			tire.setCarType(tireCarType.getText());
//			tire.setDiameter(tireDiameter.getText());
//			tire.setParams(tireParams.getText());
//		}
//		return tires;
//	}

}
