package com.qaprosoft.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.pages.TireModelPage;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigationMenu extends AbstractUIObject {
	
	@FindBy(xpath = "//div[@class='nav-wrap']//a[contains(text(),'Шины')]")
	private ExtendedWebElement tiresLink;

	public NavigationMenu(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}
	
	public TireModelPage openTireModelPage() {
		tiresLink.click();
		return new TireModelPage(driver);
	}

}
