package com.qaprosoft.automation.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.dao.mybatis.CarTireDaoImpl;
import com.qaprosoft.dao.mybatis.FreightTireDaoImpl;
import com.qaprosoft.dao.mybatis.OffRoadTireDaoImpl;
import com.qaprosoft.dao.mybatis.TyreTireDaoImpl;
import com.qaprosoft.models.CarTire;
import com.qaprosoft.models.FreightTire;
import com.qaprosoft.models.OffRoadTire;
import com.qaprosoft.models.Tire;
import com.qaprosoft.models.TyreTire;
import com.qaprosoft.pages.HomePage;
import com.qaprosoft.pages.TireModelPage;
import com.qaprosoft.pages.TiresCatalogPage;
import com.qaprosoft.services.InitialSystemService;
import com.qaprosoft.services.TireService;

public class TireTest extends UITest {
	
//	@Test(dataProvider = "DataProvider")
//	@XlsDataSourceParameters(path = "xls/tires.xlsx", sheet = "tires", dsUid = "TUID", dsArgs = "carType, width, height, diameter, type")
//	public void insertDB(String carType, String width, String height, String diameter, String type) {
//		HomePage homePage = new HomePage(getDriver());
//		homePage.open();
//		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
//		TireModelPage tireModelPage = homePage.getNavigationMenu().openTireModelPage();
//		TiresCatalogPage tireCatalogPage = tireModelPage.selectTires(carType);
//		tireCatalogPage.fillTire(diameter, type, width, height);
//		InitialSystemService initialSystem = new InitialSystemService();
//		initialSystem.fillCarTires();
//		initialSystem.fillTyreTires();
////		initialSystem.fillOffRoadTires();
////		initialSystem.fillFreightTires();
//	}

	@Test(dataProvider = "createValidTestData")
	@MethodOwner(owner = "fpetrochenkov")
	public void testValidTires(String TUID, Tire cartire) {
		List<Tire> list = new ArrayList<>();
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
		TireModelPage tireModelPage = homePage.getNavigationMenu().openTireModelPage();
		TiresCatalogPage tireCatalogPage = tireModelPage.selectTires("Легковые");
		tireCatalogPage.fillTire(cartire.getDiameter().substring(1) + "\"", cartire.getType(), cartire.getWidth(),
				cartire.getHeight());
		TireService service = new TireService();
		list.addAll(service.fillCarTireList());
		list.addAll(service.fillTyreTireList());
//		list.addAll(service.fillOffRoadTireList());
//		list.addAll(service.fillFreightTireList());
		for (Tire tire : list) {
			if (tire.getName().equals(cartire.getName())) {
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
		List<Tire> tires = new ArrayList<>();
		List<CarTire> carTires = new ArrayList<>();
		List<TyreTire> tyreTires = new ArrayList<>();
		List<OffRoadTire> offRoadTires = new ArrayList<>();
		List<FreightTire> freightTires = new ArrayList<>();
		CarTireDaoImpl carDao = new CarTireDaoImpl();
		TyreTireDaoImpl tyreDao = new TyreTireDaoImpl();
		OffRoadTireDaoImpl offRoadDao = new OffRoadTireDaoImpl();
		FreightTireDaoImpl freightDao = new FreightTireDaoImpl();
		carTires.addAll(carDao.getAllCarTires());
		tyreTires.addAll(tyreDao.getAllTyreTires());
		offRoadTires.addAll(offRoadDao.getAllOffRoadTires());
		freightTires.addAll(freightDao.getAllFreightTires());
		tires.addAll(carTires);
		tires.addAll(tyreTires);
//		tires.addAll(offRoadTires);
//		tires.addAll(freightTires);
		int size = tires.size();
		Object[][] res = new Object[size][2];
		for (int i = 0; i < size; i++) {
			res[i] = new Object[] { "TUID: " + String.format("%05d", i + 1), tires.get(i) };
		}
		return res;
	}
}
