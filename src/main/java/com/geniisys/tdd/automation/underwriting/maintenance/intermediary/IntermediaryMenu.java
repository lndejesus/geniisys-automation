package com.geniisys.tdd.automation.underwriting.maintenance.intermediary;

import org.openqa.selenium.By;

import com.geniisys.tdd.automation.common.BrowserDriver;
import com.geniisys.tdd.automation.underwriting.maintenance.intermediary.intermediary.IntermediaryListingMaintenancePage;

public class IntermediaryMenu {
	
	private BrowserDriver driver;
	
	private final By intmListingLnkLocator = By.id("intermediaryListing");
	
	public IntermediaryMenu(BrowserDriver driver) {
		this.driver = driver;
	}
	
	public IntermediaryListingMaintenancePage goToIntermediaryListingMaintenancePage() {
		driver.findClickableElement(intmListingLnkLocator).click();
		
		return new IntermediaryListingMaintenancePage(driver);
	}

}
