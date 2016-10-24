/*
 * Copyright 2013-2016 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.automation.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.pages.AdvancedSearchPage;
import com.qaprosoft.pages.CarCatalogPage;
import com.qaprosoft.pages.CarModelPage;
import com.qaprosoft.pages.HomePage;
import com.qaprosoft.pages.ParametersOfTiresPage;
import com.qaprosoft.pages.TireModelPage;
import com.qaprosoft.pages.TiresCatalogPage;

public class WebSampleTest extends UITest {

	@Test
	public void testTiresSelect() {
		// Open AV.BY home page and verify page is opened
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
		// Open tire model page
		TireModelPage tireModelPage = homePage.getNavigationMenu().openTireModelPage();
		// Select tire model and verify page is opened
		ParametersOfTiresPage parametersOfTiresPage = tireModelPage.getCatalogMenu().openParametersOfTiresPage();
		// Enter parameters of tires
		TiresCatalogPage tiresCatalogPage = parametersOfTiresPage.selectParameters("16\"", "205", "55");
		// Sort the price by descending and print the title and cost of tires
		tiresCatalogPage.sortTires();
		tiresCatalogPage.printTires();
	}

	@Test
	public void testCarModelSelect() {
		// Open AV.BY home page and verify page is opened
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
		// Select car brand
		CarModelPage carModelPage = homePage.selectBrand("Lada (ВАЗ)");
		// Select car model
		CarCatalogPage carCatalogPage = carModelPage.selectModel("Vesta");
		// Print title of cars in console
		carCatalogPage.printCars();
	}

	@Test(dataProvider = "DP")
	public void testAdvanceSearch(String brand, String model) {
		String carModel = "Audi A1";
		// Open AV.BY home page and verify page is opened
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
		// Open the advance search page and verify page is opened
		AdvancedSearchPage advancedSearchPage = homePage.search();
		Assert.assertTrue(advancedSearchPage.isPageOpened(), "Advanced search page is not opened!");
		// fill parameters of car
		CarCatalogPage carCatalogPage = advancedSearchPage.searchModel("Audi", "A1");
		// assert true title of showed cars
		Assert.assertEquals(carCatalogPage.readCarTitle(carModel), carModel, "Invalid element title!");
	}

	@DataProvider(parallel = false, name = "DP")
	public static String[][] dataprovider() {
		return new String[][] { { "Audi", "A1" }, { "BMW", "X1" } };
	}
}
