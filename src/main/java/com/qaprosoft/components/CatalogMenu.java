package com.qaprosoft.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.pages.ParametersOfTiresPage;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogMenu extends AbstractUIObject {
	
	@FindBy(xpath = "//div[@class='tyre-catalog-lists']//a[contains(text(),'зимние')]")
	private List<ExtendedWebElement> tireModelLinks;

	public CatalogMenu(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public ParametersOfTiresPage openParametersOfTiresPage() {
		tireModelLinks.get(0).click();
		return new ParametersOfTiresPage(driver);
	}
}
