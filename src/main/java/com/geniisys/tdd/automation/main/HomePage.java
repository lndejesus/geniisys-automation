package com.geniisys.tdd.automation.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.geniisys.tdd.automation.common.BrowserDriver;
import com.geniisys.tdd.automation.underwriting.UnderwritingPage;

public class HomePage {
	
	private static final Logger LOGGER = LogManager.getLogger(HomePage.class.getName());
	
	private BrowserDriver driver;
	
	private final By underwritingBtnLocator = By.id("iconUnderwriting");
	
	public HomePage(BrowserDriver driver) {
		this.driver = driver;
	}
	
	public UnderwritingPage goToUnderwriting() {
		driver.findClickableElement(underwritingBtnLocator).click();
		LOGGER.info("Go to Underwriting main page");
		
		return new UnderwritingPage(driver);
	}

}
