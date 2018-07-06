package com.geniisys.tdd.automation.underwriting.maintenance.intermediary.intermediary;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.geniisys.tdd.automation.BaseTest;

public class GIISS076Test extends BaseTest {
	
	private GIISS203Page giiss203;
	private GIISS076Page giiss076;
	
	private String currentIntmName;
	private String intmName;
	
	private final String uniqueIntmName1 = "UNIQUE INTM NAME 1 - 076";
	private final String uniqueIntmName2 = "UNIQUE INTM NAME 2 - 076";
	
	@BeforeMethod
	public void goToGiiss203() {
		giiss203 = homePage.goToUnderwriting()
						   .goToMaintenance()
						   .goToIntermediary()
						   .goToIntermediaryListingMaintenancePage();
	}
	
	@AfterMethod
	public void goToHome() {
		giiss076.goToHome();
	}
	
	private void goToGiiss076ToAddIntm() {
		giiss076 = giiss203.addIntmRecord();
	}
	
	private void goToGiiss076ToEditIntm() {
		giiss076 = giiss203.selectIntmRecord()
		   		   		   .editIntmRecord();
	}
	
	private void setCurrentAndUniqueIntmName() {
		currentIntmName = giiss076.getIntmName();
		
		if(currentIntmName.equals(uniqueIntmName1)) {
			intmName = uniqueIntmName2;
		} else {
			intmName = uniqueIntmName1;
		}
	}
	
	@Test(priority=0)
	public void addIntm() {
		goToGiiss076ToAddIntm();
	}
	
	// edit all intm info
	@Test(priority=1)
	public void editIntm() {
		goToGiiss076ToEditIntm();
		setCurrentAndUniqueIntmName();
	}
	
	@Test(priority=2)
	public void checkRequiredIntmName() {
		goToGiiss076ToEditIntm();
		setCurrentAndUniqueIntmName();
		
		giiss076.clearIntmName()		// Info message should display after clicking save
				.save()
				.setIntmName(intmName)	// Set unique value
				.save();
	}
	
	@Test(priority=3)
	public void checkRequiredIssSource() {
		goToGiiss076ToEditIntm();
		setCurrentAndUniqueIntmName();
		
		giiss076.clearIssSource()		// Info message should display after clicking save
				.save()
				.setIssSource("HO")		// Set unique value
				.save();
	}
	
	/*@Test(priority=4)
	public void checkRequiredWhtaxCd() {
		
	}
	
	@Test(priority=5)
	public void checkRequiredIntmType() {
		
	}
	
	@Test(priority=6)
	public void checkRequiredTin() {
		
	}
	
	@Test(priority=7)
	public void checkRequiredCoIntmType() {
		
	}
	
	@Test(priority=8)
	public void checkRequiredPaytTerms() {
		
	}
	
	@Test(priority=9)
	public void checkRequiredBirthDate() {
		
	}
	
	@Test(priority=10)
	public void checkRequiredMailingAddr() {
		
	}
	
	@Test(priority=11)
	public void checkRequiredEmailAddr() {
		
	}
	
	@Test(priority=12)
	public void checkRequiredParentIntmTin() {
		
	}
	
	@Test(priority=13)
	public void checkRequiredSpecialRate() {
		
	}
	
	@Test(priority=14)
	public void checkRequiredCorporate() {
		
	}
	
	@Test(priority=15)
	public void checkRequiredActiveTag() {
		
	}
	
	@Test(priority=16)
	public void checkRequiredLicensed() {
		
	}
	
	@Test(priority=17)
	public void checkRequiredInputVatRate() {
		
	}
	
	@Test(priority=18)
	public void checkEmailAddrFormat() {
		
	}*/
	
}
