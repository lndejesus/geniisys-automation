package com.geniisys.tdd.automation.underwriting.maintenance.intermediary.intermediary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.geniisys.tdd.automation.BaseTest;

public class GIISS076Test extends BaseTest {
	
private static final Logger LOGGER = LogManager.getLogger(GIISS076Test.class);
	
	private GIISS203Page giiss203;
	private GIISS076Page giiss076;
	
	@BeforeMethod
	public void goToGiiss203() {
		try {
			giiss203 = homePage.goToUnderwriting()
								.goToMaintenance()
								.goToIntermediary()
								.goToIntermediaryListingMaintenancePage();
		} catch (TimeoutException e) {
			LOGGER.error(e);
			throw e;
		}
	}
	
	@AfterMethod
	public void goToHome() {
		giiss076.goToHome();
	}
	
	@Test(priority=0)
	public void addIntm() {
		giiss076 = giiss203.dtAddIntm();
	}
	
	@Test(priority=1)
	public void editIntm() {
		giiss203.selectIntmRecord();
		
		giiss076 = giiss203.dtEditIntm();
	}

}
