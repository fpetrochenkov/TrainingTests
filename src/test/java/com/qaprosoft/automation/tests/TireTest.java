package com.qaprosoft.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.pages.HomePage;
import com.qaprosoft.pages.TireModelPage;
import com.qaprosoft.pages.TiresCatalogPage;

import services.InitialSystemService;

public class TireTest extends UITest {

	@Test(dataProvider = "DataProvider")
	@XlsDataSourceParameters(path = "xls/tires.xlsx", sheet = "tires", dsUid = "TUID", dsArgs = "carType, width, height, diameter, type")
	public void testTires(String carType, int width, int height, int diameter, String type) {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
		TireModelPage tireModelPage = homePage.getNavigationMenu().openTireModelPage();
		TiresCatalogPage tireCatalogPage = tireModelPage.getTabsFiller().selectTires(width, height, diameter, type, carType);		
		InitialSystemService initialSystem = new InitialSystemService();
		initialSystem.fillTires();
	}

}
