package com.qaprosoft.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.pages.CarCatalogPage;
import com.qaprosoft.pages.HomePage;
import com.qaprosoft.pages.LogInPage;

public class DataprovidesSampleTest extends UITest {

	@Test
	@Parameters({ "brand", "model", "yearFrom", "yearTo", "priceFrom", "priceTo" })
	public void testTabsFiller(String brand, String model, String yearFrom, String yearTo, String priceFrom,
			String priceTo) {
		// Open AV.BY home page and verify page is opened
		String expected = brand + " " + model;
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
		CarCatalogPage carCatalogPage = homePage.selectCars(brand, model, yearFrom, yearTo, priceFrom, priceTo);
		Assert.assertEquals(carCatalogPage.readCarTitle(expected), expected, "Invalid info!");
	}

	@Test(dataProvider = "DataProvider")
	@XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "LoginInfo", dsUid = "TUID", dsArgs = "login, password")
	public void testLoginPage(String login, String password) {
		// Open AV.BY home page and verify page is opened
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
		// Open Log In Page and verify page is opened
		LogInPage logInPage = homePage.signIn();
		homePage = logInPage.logIn(login, password);
		Assert.assertTrue(homePage.isPageOpened(), "Incorrect login info!");
	}
}
