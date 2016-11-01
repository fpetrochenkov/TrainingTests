package com.qaprosoft.automation.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.dao.mybatis.CarTireDaoImpl;
import com.qaprosoft.models.CarTire;
import com.qaprosoft.pages.HomePage;
import com.qaprosoft.pages.TireModelPage;
import com.qaprosoft.pages.TiresCatalogPage;
import com.qaprosoft.services.InitialSystemService;
import com.qaprosoft.services.TireService;

public class TireTest extends UITest {

	// @Test(dataProvider = "DataProvider")
	// @XlsDataSourceParameters(path = "xls/tires.xlsx", sheet = "tires", dsUid
	// = "TUID", dsArgs = "carType, width, height, diameter, type")
	// public void testTires(String carType, String width, String height, String
	// diameter, String type) {
	// HomePage homePage = new HomePage(getDriver());
	// homePage.open();
	// Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
	// TireModelPage tireModelPage =
	// homePage.getNavigationMenu().openTireModelPage();
	// TiresCatalogPage tireCatalogPage =
	// tireModelPage.getTabsFiller().selectTires(carType);
	// tireCatalogPage.fillTire(diameter, type, width, height);
	// InitialSystemService initialSystem = new InitialSystemService();
	// initialSystem.fillTires();
	// }

	@Test(dataProvider = "createValidTestData")
	@MethodOwner(owner = "fpetrochenkov")
	@XlsDataSourceParameters(path = "xls/tires.xlsx", sheet = "tires", dsUid = "TUID", dsArgs = "carType, width, height, diameter, type")
	public void testValidTires(String TUID, CarTire cartire, String carType, String width, String height,
			String diameter, String type) {
		CarTireDaoImpl carDao = new CarTireDaoImpl();
		// Open AV.BY home page and verify page is opened
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
		TireModelPage tireModelPage = homePage.getNavigationMenu().openTireModelPage();
		TiresCatalogPage tireCatalogPage = tireModelPage.getTabsFiller().selectTires("Легковые");
		tireCatalogPage.fillTire(diameter, type, width, height);
		TireService service = new TireService();
		Object[][] exp = new Object[carDao.getAllCarTires().size()][];
		for (int i = 0; i < carDao.getAllCarTires().size(); i++) {
			exp[i] = new Object[] { "TUID: " + String.format("%05d", i + 1), service.fillList().get(i) };
		}
		for (int i = 0; i < createValidTestData().length; i++) {
			for (int j = 0; j < exp.length; j++) {
				Assert.assertEquals(createValidTestData()[i], exp[j], "There is no such element!");
			}
		}
	}

	@DataProvider(name = "createValidTestData")
	public Object[][] createValidTestData() {
		CarTireDaoImpl carDao = new CarTireDaoImpl();
		Object[][] res = new Object[carDao.getAllCarTires().size()][];
		for (int i = 0; i < carDao.getAllCarTires().size(); i++) {
			res[i] = new Object[] { "TUID: " + String.format("%05d", i + 1), carDao.getAllCarTires().get(i) };
		}
		return res;
	}
}
