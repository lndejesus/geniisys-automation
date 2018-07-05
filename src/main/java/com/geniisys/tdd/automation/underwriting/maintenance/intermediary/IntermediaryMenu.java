package com.geniisys.tdd.automation.underwriting.maintenance.intermediary;

import org.openqa.selenium.By;

import com.geniisys.tdd.automation.common.BrowserDriver;
import com.geniisys.tdd.automation.underwriting.maintenance.intermediary.intermediary.GIISS203Page;

public class IntermediaryMenu {
	
	private BrowserDriver driver;
	
	private final By intmListingLnkLocator = By.id("intermediaryListing");
	
	public IntermediaryMenu(BrowserDriver driver) {
		this.driver = driver;
	}
	
	public GIISS203Page goToIntermediaryListingMaintenancePage() {
		driver.findClickableElement(intmListingLnkLocator).click();
		
		return new GIISS203Page(driver);
	}

}
