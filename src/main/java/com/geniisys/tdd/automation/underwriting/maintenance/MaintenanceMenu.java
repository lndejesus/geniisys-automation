package com.geniisys.tdd.automation.underwriting.maintenance;

import org.openqa.selenium.By;

import com.geniisys.tdd.automation.common.BrowserDriver;
import com.geniisys.tdd.automation.underwriting.maintenance.intermediary.IntermediaryMenu;

public class MaintenanceMenu {
	
	private BrowserDriver driver;
	
	private final By intermediaryLnkLocator = By.id("intermediary");
	
	public MaintenanceMenu(BrowserDriver driver) {
		this.driver = driver;
	}
	
	public IntermediaryMenu goToIntermediary() {
		driver.findClickableElement(intermediaryLnkLocator).click();
		
		return new IntermediaryMenu(driver);
	}

}
