package com.qaprosoft.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class ParametersOfTiresPage extends AbstractPage {

	@FindBy(xpath = "//div[@class='b-subnav']//a")
	private List<ExtendedWebElement> parameterLinks;

	public ParametersOfTiresPage(WebDriver driver) {
		super(driver);
	}

	public TiresCatalogPage selectParameters(String diameter, String width, String height) {
		for (ExtendedWebElement parameterLink : parameterLinks) {
			if (diameter.equalsIgnoreCase(parameterLink.getText())) {
				parameterLink.click();
			}
		}
		for (ExtendedWebElement parameterLink : parameterLinks) {
			if (width.equalsIgnoreCase(parameterLink.getText())) {
				parameterLink.click();
			}
		}
		for (ExtendedWebElement parameterLink : parameterLinks) {
			if (height.equalsIgnoreCase(parameterLink.getText())) {
				parameterLink.click();
				return new TiresCatalogPage(driver);
			}
		}
		throw new RuntimeException("Unable to select parameter!");
	}

}
