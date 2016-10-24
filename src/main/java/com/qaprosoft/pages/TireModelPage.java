package com.qaprosoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.pagecomponents.CatalogMenu;

public class TireModelPage extends AbstractPage {
	
	@FindBy(xpath = "//div[@class='tyre-popular']")
	private CatalogMenu tireMenu;

	public TireModelPage(WebDriver driver) {
		super(driver);
	}
	
	public CatalogMenu getCatalogMenu() {
		return tireMenu;
	}

}
