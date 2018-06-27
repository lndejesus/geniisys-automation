package com.geniisys.tdd.automation.underwriting;

import org.openqa.selenium.By;

import com.geniisys.tdd.automation.common.BrowserDriver;
import com.geniisys.tdd.automation.underwriting.maintenance.MaintenanceMenu;

public class UnderwritingPage {
	
	private BrowserDriver driver;
	
	private final By maintenanceLnkLocator = By.linkText("Maintenance");
	
	public UnderwritingPage(BrowserDriver driver) {
		this.driver = driver;
	}
	
	public MaintenanceMenu goToMaintenance() {
		driver.findClickableElement(maintenanceLnkLocator).click();
		
		return new MaintenanceMenu(driver);
	}

}
