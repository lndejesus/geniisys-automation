package com.geniisys.tdd.automation.underwriting.maintenance.intermediary.intermediary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.geniisys.tdd.automation.common.MessageOverlay;
import com.geniisys.tdd.automation.common.BrowserDriver;

public class IntermediaryListingMaintenancePage {
	
	private static final Logger LOGGER = LogManager.getLogger(IntermediaryListingMaintenancePage.class);
	
	private BrowserDriver driver;
	private MessageOverlay messageOverlay;
	
	private final By homeBtnLocator = By.id("footerHome");
	
	// Data table elements
	private final By addTabLocator = By.xpath("//div[contains (@class, 'dtbl-add-btn')]");
	private final By editTabLocator = By.xpath("//div[contains (@class, 'dtbl-edit-btn')]");
	private final By intmRecordTabLocator = By.xpath("//div[contains (@class, 'tabulator-row')]");
	
	// Field elements
	private final By activeTagChkLocator = By.id("chkActiveTag");
	private final By intmNameTxtLocator = By.id("txtIntmName");
	private final By refIntmCdTxtLocator = By.id("txtRefIntmCd");
	private final By RemarksTxtLocator = By.id("txtRemarks");
	private final By updateBtnLocator = By.id("btnUpdate");
	
	public IntermediaryListingMaintenancePage(BrowserDriver driver) {
		this.driver = driver;
		this.messageOverlay = new MessageOverlay(driver);
	}
	
	public IntermediaryListingMaintenancePage goToHome() {
		driver.findElement(homeBtnLocator).click();
		return new IntermediaryListingMaintenancePage(driver);
	}
	
	public IntermediaryListingMaintenancePage selectIntmRecord() {
		driver.findElement(intmRecordTabLocator).click();
		return new IntermediaryListingMaintenancePage(driver);
	}
	
	public IntermediaryListingMaintenancePage setActiveTag(String active) {
		if("A".equals(active)) {
			if(!driver.findElement(activeTagChkLocator).isSelected()) {
				driver.findClickableElement(activeTagChkLocator).click();
			}
		} else if("I".equals(active)) {
			if(driver.findElement(activeTagChkLocator).isSelected()) {
				driver.findClickableElement(activeTagChkLocator).click();
			}
		}
		
		return new IntermediaryListingMaintenancePage(driver);
	}
	
	public IntermediaryListingMaintenancePage setIntmName(String intmName) {
		driver.findElement(intmNameTxtLocator).clear();
		driver.findElement(intmNameTxtLocator).sendKeys(intmName, Keys.ENTER);
		
		if(messageOverlay.getMessageType().contains("INFORMATION")) {
			LOGGER.info("Message prompt displayed.");
			messageOverlay.clickOk();
		}
		
		return new IntermediaryListingMaintenancePage(driver);
	}
	
	public String getIntmName() {
		return driver.findElement(intmNameTxtLocator).getAttribute("value");
	}
	
	public IntermediaryListingMaintenancePage clearIntmName() {
		driver.findElement(intmNameTxtLocator).clear();
		return new IntermediaryListingMaintenancePage(driver);
	}
	
	public IntermediaryListingMaintenancePage setRefIntmCode(String refCd) {
		driver.findElement(refIntmCdTxtLocator).clear();
		driver.findElement(refIntmCdTxtLocator).sendKeys(refCd);
		return new IntermediaryListingMaintenancePage(driver);
	}
	
	public IntermediaryListingMaintenancePage setRemarks(String remarks) {
		driver.findElement(RemarksTxtLocator).clear();
		driver.findElement(RemarksTxtLocator).sendKeys(remarks);
		return new IntermediaryListingMaintenancePage(driver);
	}
	
	public IntermediaryListingMaintenancePage updateChanges() {
		driver.findClickableElement(updateBtnLocator).click();
		LOGGER.info("'Update' button clicked.");
		
		if(messageOverlay.getMessageType().contains("SUCCESS") ||
				messageOverlay.getMessageType().contains("INFORMATION")) {
			LOGGER.info("Message prompt displayed.");
			messageOverlay.clickOk();
		}
		
		return new IntermediaryListingMaintenancePage(driver);
	}
	
	public IntermediaryMaintenancePage dtAddIntm() {
		driver.findElement(addTabLocator).click();
		
		return new IntermediaryMaintenancePage(driver);
	}
	
	public IntermediaryMaintenancePage dtEditIntm() {
		driver.findElement(editTabLocator).click();
		
		return new IntermediaryMaintenancePage(driver);
	}

}
