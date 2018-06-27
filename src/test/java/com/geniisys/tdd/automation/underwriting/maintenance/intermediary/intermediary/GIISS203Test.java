package com.geniisys.tdd.automation.underwriting.maintenance.intermediary.intermediary;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.geniisys.tdd.automation.BaseTest;
import com.geniisys.tdd.automation.underwriting.maintenance.intermediary.intermediary.IntermediaryListingMaintenancePage;

public class GIISS203Test extends BaseTest {
	
	private IntermediaryListingMaintenancePage giiss203;
	
	private String currentIntmName;
	private String intmName;
	
	private final String uniqueIntmName1 = "UNIQUE INTM NAME 1";
	private final String uniqueIntmName2 = "UNIQUE INTM NAME 2";
	
	@BeforeMethod
	public void goToGiiss203() {
		giiss203 = homePage.goToUnderwriting()
								.goToMaintenance()
								.goToIntermediary()
								.goToIntermediaryListingMaintenancePage();
	}
	
	@AfterMethod
	public void goToHome() {
		giiss203.goToHome();
	}
	
	private void setCurrentAndUniqueIntmName() {
		currentIntmName = giiss203.getIntmName();
		
		if(currentIntmName.equals(uniqueIntmName1)) {
			intmName = uniqueIntmName2;
		} else {
			intmName = uniqueIntmName1;
		}
	}
	
	@Test(priority=0)
	public void modifyIntmDetailsAndSetUniqueIntmName() {
		giiss203.selectIntmRecord();
		
		setCurrentAndUniqueIntmName();
		
		giiss203.setIntmName(intmName)
				.updateChanges();
	}
	
	@Test(priority=1)
	public void modifyIntmDetailsAndSetExistingIntmName() {
		giiss203.selectIntmRecord();
		
		setCurrentAndUniqueIntmName();
		
		giiss203.setIntmName(currentIntmName)	// Set existing value
				.setIntmName(intmName)			// Set unique value
				.updateChanges();
	}
	
	@Test(priority=2)
	public void modifyIntmDetailsAndSetIntmNameToNull() {
		giiss203.selectIntmRecord();
		
		setCurrentAndUniqueIntmName();
		
		giiss203.clearIntmName()		// Info message should display after clicking update
				.updateChanges()
				.setIntmName(intmName)	// Set unique value
				.updateChanges();
	}

}
