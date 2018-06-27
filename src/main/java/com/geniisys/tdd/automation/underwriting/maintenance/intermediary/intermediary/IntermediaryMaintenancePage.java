package com.geniisys.tdd.automation.underwriting.maintenance.intermediary.intermediary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.geniisys.tdd.automation.common.DatePicker;
import com.geniisys.tdd.automation.common.BrowserDriver;
import com.geniisys.tdd.automation.common.MessageOverlay;

public class IntermediaryMaintenancePage {
	
	private static final Logger LOGGER = LogManager.getLogger(IntermediaryMaintenancePage.class);
	
	private BrowserDriver driver;
	private DatePicker datePicker;
	private MessageOverlay messageOverlay;
	
	private final By homeBtnLocator = By.id("footerHome");
	
	// Field elements
	private final By refIntmCdTxtLocator = By.id("refIntmCd");
	private final By caNoTxtLocator = By.id("caNo");
	private final By caDateImgLocator = By.id("imgCaDate");
	
	private final By designationTxtLocator = By.id("designation");
	private final By intmNameTxtLocator = By.id("intmName");
	
	private final By parentIntmNoImgLocator = By.id("searchParentIntmNoLOV");
	
	private final By contactPersonTxtLocator = By.id("contactPerson");
	private final By phoneNoTxtLocator = By.id("phoneNo");
	
	private final By issCdImgLocator = By.id("searchIssCdLOV");
	private final By oldIntmNoTxtLocator = By.id("oldIntmNo");
	
	private final By whtaxCdImgLocator = By.id("searchWhtaxCodeLOV");
	
	private final By intmTypeImgLocator = By.id("searchIntmTypeLOV");
	private final By tinTxtLocator = By.id("tin");
	
	private final By coIntmTypeImgLocator = By.id("searchCoIntmTypeLOV");
	
	private final By paytTermsImgLocator = By.id("searchPaytTermsLOV");
	private final By birthdateImgLocator = By.id("imgBirthdate");
	
	private final By mailAddr1TxtLocator = By.id("mailAddr1");
	private final By mailAddr2TxtLocator = By.id("mailAddr2");
	private final By mailAddr3TxtLocator = By.id("mailAddr3");
	
	private final By billAddr1TxtLocator = By.id("billAddr1");
	private final By billAddr2TxtLocator = By.id("billAddr2");
	private final By billAddr3TxtLocator = By.id("billAddr3");
	
	private final By emailAddrTxtLocator = By.id("emailAddr");
	
	private final By parentIntmTinTxtLocator = By.id("prntIntmTinSw");
	private final By specialRateTxtLocator = By.id("specialRate");
	private final By lfTagTxtLocator = By.id("lfTag");
	private final By corpTagTxtLocator = By.id("corpTag");
	private final By activeTagTxtLocator = By.id("activeTag");
	private final By licTagTxtLocator = By.id("licTag");
	private final By inputVatRateTxtLocator = By.id("inputVatRate");
	private final By historyImgLocator = By.id("btnHistory");
	
	private final By remarksTxtLocator = By.id("remarks");
	
	public IntermediaryMaintenancePage(BrowserDriver driver) {
		this.driver = driver;
		this.datePicker = new DatePicker(driver);
		this.messageOverlay = new MessageOverlay(driver);
	}
	
	public IntermediaryMaintenancePage goToHome() {
		driver.findElement(homeBtnLocator).click();
		return new IntermediaryMaintenancePage(driver);
	}
	
	public IntermediaryMaintenancePage setRefIntmCode(String refCd) {
		driver.findElement(refIntmCdTxtLocator).clear();
		driver.findElement(refIntmCdTxtLocator).sendKeys(refCd);
		return new IntermediaryMaintenancePage(driver);
	}
	
	public IntermediaryMaintenancePage setCANo(String caNo) {
		driver.findElement(caNoTxtLocator).clear();
		driver.findElement(caNoTxtLocator).sendKeys(caNo);
		return new IntermediaryMaintenancePage(driver);
	}
	
	// Sample date format ["Jan-01-2018" or "Jan/01/2018/"] day should be two digit
	public IntermediaryMaintenancePage setCADate(String date) {
		datePicker.setDate(caDateImgLocator, date);
		return new IntermediaryMaintenancePage(driver);
	}
	
	public IntermediaryMaintenancePage setIntmDesignation(String designation) {
		driver.findElement(designationTxtLocator).clear();
		driver.findElement(designationTxtLocator).sendKeys(designation);
		return new IntermediaryMaintenancePage(driver);
	}
	
	
	
	
	
	
	
	
	
	public IntermediaryMaintenancePage setIntmName(String intmName) {
		driver.findElement(intmNameTxtLocator).clear();
		driver.findElement(intmNameTxtLocator).sendKeys(intmName, Keys.ENTER);
		
		if(messageOverlay.getMessageType().contains("INFORMATION")) {
			LOGGER.info("Message prompt displayed.");
			messageOverlay.clickOk();
		}
		
		return new IntermediaryMaintenancePage(driver);
	}
	
	public String getIntmName() {
		return driver.findElement(intmNameTxtLocator).getAttribute("value");
	}
	
	public IntermediaryMaintenancePage clearIntmName() {
		driver.findElement(intmNameTxtLocator).clear();
		return new IntermediaryMaintenancePage(driver);
	}

}
