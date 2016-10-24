package com.qaprosoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class LogInPage extends AbstractPage {
	
	@FindBy(id = "login")
	private ExtendedWebElement log;
	
	@FindBy(id = "password")
	private ExtendedWebElement pass;
	
	@FindBy(name = "submit")
	private ExtendedWebElement submit;

	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	
	public HomePage logIn(String login, String password) {
		log.type(login);
		pass.type(password);
		submit.click();
		return new HomePage(driver);
	}
	
}
