package com.geniisys.tdd.automation.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.geniisys.tdd.automation.common.BrowserDriver;

public class LoginPage {
	
	private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);
	
	private BrowserDriver driver;
	
	private final By usernameTxtLocator = By.id("userId");
	private final By passwordTxtLocator = By.id("password");
	private final By submitBtnLocator = By.id("loginButton");
	
	public LoginPage(BrowserDriver driver) {
		this.driver = driver;
	}
	
	public HomePage loginAs(String username, String password) {
		driver.findElement(usernameTxtLocator).sendKeys(username);
		LOGGER.info("Username field value set to '" + username + "'.");
		
		driver.findElement(passwordTxtLocator).sendKeys(password);
		LOGGER.info("Password set.");
		
		driver.findClickableElement(submitBtnLocator).click();
		LOGGER.info("Submit button clicked.");

		return new HomePage(driver);
	}

}
