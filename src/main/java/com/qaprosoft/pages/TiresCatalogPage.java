package com.qaprosoft.pages;


import java.util.ArrayList;
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
	
	@FindBy(xpath = "//div[@class='b-subnav']//li/a")
	private List<ExtendedWebElement> tireDiameters;	
	
	@FindBy(xpath = "//div[@class='b-subnav']//li/a")
	private List<ExtendedWebElement> tireTypes;
	
	@FindBy(xpath = "//div[@class='b-subnav']//li/a")
	private List<ExtendedWebElement> tireWidthes;
	
	@FindBy(xpath = "//div[@class='b-subnav']//li/a")
	private List<ExtendedWebElement> tireHeights;
	
	
	
	
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div/div[1]/div[1]/div/div/ul/li[2]/a/span")
	private ExtendedWebElement carType;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div/div[1]/div[1]/div/div/ul/li[3]/a/span")
	private ExtendedWebElement type;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div/div[1]/div[1]/div/div/ul/li[4]/a/span")
	private ExtendedWebElement diameter;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/main/div/div[1]/div[1]/div/div/ul/li[5]/span")
	private ExtendedWebElement width_height;
	
	
	
	
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
	
	public void fillTire(String diameter, String type, String width, String height) {
		for(ExtendedWebElement tireDiameter: tireDiameters) {
			if(tireDiameter.getText().equalsIgnoreCase(diameter)) {	
				tireDiameter.click();
			}
		}
		for(ExtendedWebElement tireType: tireTypes) {
			if(tireType.getText().equalsIgnoreCase(type)) {
				click(tireType);
			}
		}
		for(ExtendedWebElement tireWidth: tireWidthes) {
			if(tireWidth.getText().equalsIgnoreCase(width)) {
				click(tireWidth);
			}
		}
		for(ExtendedWebElement tireHeight: tireHeights) {
			if(tireHeight.getText().equalsIgnoreCase(height)) {
				click(tireHeight);
				break;
			}
		}
	}
	
	public List<String> getTireTitles() {
		List<String> list = new ArrayList<>();
		for(ExtendedWebElement tireTitle: tireTitles) {			
			list.add(tireTitle.getText());
		}
		return list;
	}
	
	public List<String> getTirePrices() {
		List<String> list = new ArrayList<>();
		for(ExtendedWebElement tireCost: tireCosts) {			
			list.add(tireCost.getText());
		}
		return list;
	}
	
	public String getType() {
		return type.getText();
	}
	
	public String getDiameter() {
		return diameter.getText().substring(0);
	}
	
	public String getWidth() {
		return width_height.getText().substring(0, 3);
	}
	
	public String getHeight() {
		return width_height.getText().substring(4);
	}
	
	public String getCarType() {
		return carType.getText();
	}
	
}
