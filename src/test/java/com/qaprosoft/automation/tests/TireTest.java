package com.qaprosoft.automation.tests;

import java.util.ArrayList;
import java.util.List;

import  org.testng.Assert;
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

//	 @Test(dataProvider = "DataProvider")
//	 @XlsDataSourceParameters(path = "xls/tires.xlsx", sheet = "tires", dsUid
//	 = "TUID", dsArgs = "carType, width, height, diameter, type")
//	 public void testTires(String carType, String width, String height, String
//	 diameter, String type) {
//	 HomePage homePage = new HomePage(getDriver());
//	 homePage.open();
//	 Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
//	 TireModelPage tireModelPage =
//	 homePage.getNavigationMenu().openTireModelPage();
//	 TiresCatalogPage tireCatalogPage =
//	 tireModelPage.getTabsFiller().selectTires(carType);
//	 tireCatalogPage.fillTire(diameter, type, width, height);
//	 InitialSystemService initialSystem = new InitialSystemService();
//	 initialSystem.fillTires();
//	 }

	@Test(dataProvider = "createValidTestData")
	@MethodOwner(owner = "fpetrochenkov")
	public void testValidTires(String TUID, CarTire cartire) {
		//Open AV.BY home page and verify page is opened
		List<CarTire> list = new ArrayList<>();
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");	
		TireModelPage tireModelPage = homePage.getNavigationMenu().openTireModelPage();		
		TiresCatalogPage tireCatalogPage = tireModelPage.getTabsFiller().selectTires("Легковые");
		tireCatalogPage.fillTire(cartire.getDiameter().substring(1) + "\"", cartire.getType(), cartire.getWidth(), cartire.getHeight());
		TireService service = new TireService();
		list.addAll(service.fillList());
		for(CarTire tire: list) {
			if(tire.getName().equals(cartire.getName())) {
			Assert.assertEquals(tire.getName(), cartire.getName(), "The name is not match!");
			Assert.assertEquals(tire.getPrice(), cartire.getPrice(), "The price is not match!");
			Assert.assertEquals(tire.getDiameter(), cartire.getDiameter(), "The diameter is not match");
			Assert.assertEquals(tire.getType(), cartire.getType(), "Type is not match!");
			Assert.assertEquals(tire.getWidth(), cartire.getWidth(), "Width is not match!");
			Assert.assertEquals(tire.getHeight(), cartire.getHeight(), "Height is not match!");
			}
		}		
	}

	@DataProvider(name = "createValidTestData")
	public Object[][] createValidTestData() {
		List<CarTire> carTires = new ArrayList<>();
		CarTireDaoImpl carDao = new CarTireDaoImpl();
		int size = carDao.getAllCarTires().size();
		carTires.addAll(carDao.getAllCarTires());
		Object[][] res = new Object[size][2];
		for (int i = 0; i < size; i++) {
			res[i] = new Object[] { "TUID: " + String.format("%05d", i + 1), carTires.get(i) };
		}
		return res;
	}
}
