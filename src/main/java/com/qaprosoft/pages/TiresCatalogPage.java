package com.qaprosoft.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class TiresCatalogPage extends AbstractPage {
	
	@FindBy(xpath = "//a[@class='sorting-item'][contains(text(),'цене за 1 шт.')]")
	private ExtendedWebElement sorting;
	
	@FindBy(xpath = "//div[@class='tyre-listing-about']//a")
	private List<ExtendedWebElement> tireTitles;
	
	@FindBy(xpath = "//div[@class='tyre-listing-price']/h5")
	private List<ExtendedWebElement> tireCosts;

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

}
