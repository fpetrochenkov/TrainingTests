package com.qaprosoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.components.CatalogMenu;
import com.qaprosoft.components.TabsFiller;

public class TireModelPage extends AbstractPage {
	
	@FindBy(xpath = "//div[@class='tyre-catalog-lists']//a[contains(text(),'зимние')]")
	private CatalogMenu tireMenu;
	
	@FindBy(xpath="//div[@class='tabsfilter']")
	private TabsFiller tabsFiller;
	
	public TireModelPage(WebDriver driver) {
		super(driver);
	}
	
	public CatalogMenu getCatalogMenu() {
		return tireMenu;
	}
	
	public TabsFiller getTabsFiller() {
		return tabsFiller;
	}

}
