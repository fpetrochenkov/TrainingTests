package com.qaprosoft.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CarModelPage extends AbstractPage {	
//	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div/div[3]/div[1]/ul/li[28]/a/span")
	@FindBy(xpath = "//div[@class='brands']//a/span")
	private List<ExtendedWebElement> modelLinks;

	public CarModelPage(WebDriver driver) {
		super(driver);
	}
	
	public CarCatalogPage selectModel(String model) {
		for(ExtendedWebElement modelLink: modelLinks) {
			if(model.equals(modelLink.getText())){
				modelLink.click();
				break;
			}
		}
		return new CarCatalogPage(driver);
	}

}
