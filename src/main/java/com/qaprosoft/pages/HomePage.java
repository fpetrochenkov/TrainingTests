package com.qaprosoft.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.components.NavigationMenu;

public class HomePage extends AbstractPage {

	@FindBy(xpath = "//div[@class='brands']//a/span")
	private List<ExtendedWebElement> brandLinks;

	@FindBy(id = "search_extend_link")
	private ExtendedWebElement advancedSearch;

	@FindBy(xpath = "//div[@class='nav-wrap']")
	private NavigationMenu navigationMenu;

	@FindBy(name = "brand_id")
	private ExtendedWebElement selectBrand;

	@FindBy(id = "model_id")
	private ExtendedWebElement selectModel;

	@FindBy(xpath = "//div[@class='dropselect-head js-dropselect-head dropselect-head-year']")
	private ExtendedWebElement selectYear;

	@FindBy(name = "year_from")
	private ExtendedWebElement chooseYearFrom;

	@FindBy(name = "year_to")
	private ExtendedWebElement chooseYearTo;

	@FindBy(xpath = "//div[@class='dropselect-head js-dropselect-head dropselect-head-price']")
	private ExtendedWebElement selectCost;

	@FindBy(name = "price_from")
	private ExtendedWebElement costFrom;

	@FindBy(name = "price_to")
	private ExtendedWebElement costTo;
	
	@FindBy(id = "submit_presearch")
	private ExtendedWebElement search;
	
	@FindBy(xpath = "//p[@class='userarea-sign']//a[contains(text(),'Войдите')]")
	private ExtendedWebElement signIn;

	public HomePage(WebDriver driver) {
		super(driver);
		setPageURL(R.TESTDATA.get("url_home_page"));
	}

	public NavigationMenu getNavigationMenu() {
		return navigationMenu;
	}

	public AdvancedSearchPage search() {
		advancedSearch.click();
		return new AdvancedSearchPage(driver);
	}

	public CarModelPage selectBrand(String brand) {
		for (ExtendedWebElement brandLink : brandLinks) {
			if (brand.equalsIgnoreCase(brandLink.getText())) {
				brandLink.click();
				return new CarModelPage(driver);
			}
		}
		throw new RuntimeException("Unable to open brand: " + brand);
	}

	public CarCatalogPage selectCars(String brand, String model, String yearFrom, String yearTo, String priceFrom,
			String priceTo) {
		selectBrand.select(brand);
		selectModel.select(model);
		selectYear.click();
		chooseYearFrom.select(yearFrom);
		chooseYearTo.select(yearTo);
		selectCost.click();
		costFrom.select(priceFrom);
		costTo.select(priceTo);
		search.click();
		return new CarCatalogPage(driver);
	}

	public LogInPage signIn() {
		signIn.click();
		return new LogInPage(driver);
	}
}
