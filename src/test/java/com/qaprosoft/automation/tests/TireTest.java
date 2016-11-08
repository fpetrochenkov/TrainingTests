package com.qaprosoft.automation.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.dao.mybatis.CarDaoImpl;
import com.qaprosoft.dao.mybatis.LightTruckDaoImpl;
import com.qaprosoft.dao.mybatis.SuvDaoImpl;
import com.qaprosoft.dao.mybatis.TruckDaoImpl;
import com.qaprosoft.models.Car;
import com.qaprosoft.models.Truck;
import com.qaprosoft.models.Suv;
import com.qaprosoft.models.Tire;
import com.qaprosoft.models.LightTruck;
import com.qaprosoft.pages.HomePage;
import com.qaprosoft.pages.TireModelPage;
import com.qaprosoft.pages.TiresCatalogPage;
import com.qaprosoft.services.InitialSystemService;
import com.qaprosoft.services.TireService;

public class TireTest extends UITest {

	@Test(dataProvider = "DataProvider")
	@XlsDataSourceParameters(path = "xls/tires.xlsx", sheet = "tires", dsUid = "TUID", dsArgs = "carType, width, height, diameter, type")
	public void fillDB(String carType, String width, String height, String diameter, String type) {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
		TireModelPage tireModelPage = homePage.getNavigationMenu().openTireModelPage();
		TiresCatalogPage tireCatalogPage = tireModelPage.selectTires(carType);
		InitialSystemService initialSystem = new InitialSystemService();
		if (carType.equals("Легковые") || carType.equals("Легкогрузовые")) {
			tireCatalogPage.fillCarAndLightTruckTire(diameter, type, width, height);
			initialSystem.fillCars();
			initialSystem.fillLightTrucks();
		}
		if (carType.equals("Внедорожные") || carType.equals("Грузовые")) {
			tireCatalogPage.fillTruckAndSuvTire(diameter, type, width, height);
			initialSystem.fillSuves();
			initialSystem.fillTrucks();
		}
	}

	@Test(dataProvider = "createValidTestData")
	@MethodOwner(owner = "fpetrochenkov")
	public void testValidTires(String TUID, Tire cartire) {
		String carType = "Внедорожные";
		List<Tire> list = new ArrayList<>();
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
		TireModelPage tireModelPage = homePage.getNavigationMenu().openTireModelPage();
		TiresCatalogPage tireCatalogPage = tireModelPage.selectTires(carType);
		TireService service = new TireService();
		if (carType.equals("Легковые") || carType.equals("Легкогрузовые")) {
			tireCatalogPage.fillCarAndLightTruckTire(cartire.getDiameter().substring(1) + "\"", cartire.getType(),
					cartire.getWidth(), cartire.getHeight());
			list.addAll(service.fillCarList());
			list.addAll(service.fillLightTruckList());
		}
		if (carType.equals("Внедорожные") || carType.equals("Грузовые")) {
			tireCatalogPage.fillTruckAndSuvTire(cartire.getType(), cartire.getDiameter().substring(1) + "\"",
					cartire.getWidth(), cartire.getHeight());
			list.addAll(service.fillSuvList());
			list.addAll(service.fillTruckList());
		}		
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
		List<Car> cars = new ArrayList<>();
		List<LightTruck> lightTrucks = new ArrayList<>();
		List<Suv> suves = new ArrayList<>();
		List<Truck> trucks = new ArrayList<>();
		CarDaoImpl carDao = new CarDaoImpl();
		TruckDaoImpl truckDao = new TruckDaoImpl();
		SuvDaoImpl suvDao = new SuvDaoImpl();
		LightTruckDaoImpl lightTruckDao = new LightTruckDaoImpl();
		cars.addAll(carDao.getAllCars());
		lightTrucks.addAll(lightTruckDao.getAllLightTrucks());
		suves.addAll(suvDao.getAllSuves());
		trucks.addAll(truckDao.getAllTrucks());
		tires.addAll(cars);
		tires.addAll(lightTrucks);
		tires.addAll(suves);
		tires.addAll(trucks);
		int size = tires.size();
		Object[][] res = new Object[size][2];
		for (int i = 0; i < size; i++) {
			res[i] = new Object[] { "TUID: " + String.format("%05d", i + 1), tires.get(i) };
		}
		return res;
	}
}
