package com.geniisys.tdd.automation.underwriting.maintenance.intermediary.intermediary.giiss203;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.geniisys.tdd.automation.common.MessageOverlay;
import com.geniisys.tdd.automation.underwriting.maintenance.intermediary.intermediary.giiss076.GIISS076Page;
import com.geniisys.tdd.automation.common.BrowserDriver;

public class GIISS203Page {
	
	private static final Logger LOGGER = LogManager.getLogger(GIISS203Page.class);
	
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
	
	public GIISS203Page(BrowserDriver driver) {
		this.driver = driver;
		this.messageOverlay = new MessageOverlay(driver);
	}
	
	public GIISS203Page goToHome() {
		driver.findElement(homeBtnLocator).click();
		return new GIISS203Page(driver);
	}
	
	public GIISS203Page selectIntmRecord() {
		driver.findElement(intmRecordTabLocator).click();
		return new GIISS203Page(driver);
	}
	
	public GIISS203Page setActiveTag(String active) {
		if("A".equals(active)) {
			if(!driver.findElement(activeTagChkLocator).isSelected()) {
				driver.findClickableElement(activeTagChkLocator).click();
			}
		} else if("I".equals(active)) {
			if(driver.findElement(activeTagChkLocator).isSelected()) {
				driver.findClickableElement(activeTagChkLocator).click();
			}
		}
		
		return new GIISS203Page(driver);
	}
	
	public GIISS203Page setIntmName(String intmName) {
		driver.findElement(intmNameTxtLocator).clear();
		driver.findElement(intmNameTxtLocator).sendKeys(intmName, Keys.ENTER);
		
		if(messageOverlay.getMessageType().contains("INFORMATION")) {
			LOGGER.info("Message prompt displayed.");
			messageOverlay.clickOk();
		}
		
		return new GIISS203Page(driver);
	}
	
	public String getIntmName() {
		return driver.findElement(intmNameTxtLocator).getAttribute("value");
	}
	
	public GIISS203Page clearIntmName() {
		driver.findElement(intmNameTxtLocator).clear();
		return new GIISS203Page(driver);
	}
	
	public GIISS203Page setRefIntmCode(String refCd) {
		driver.findElement(refIntmCdTxtLocator).clear();
		driver.findElement(refIntmCdTxtLocator).sendKeys(refCd);
		return new GIISS203Page(driver);
	}
	
	public GIISS203Page setRemarks(String remarks) {
		driver.findElement(RemarksTxtLocator).clear();
		driver.findElement(RemarksTxtLocator).sendKeys(remarks);
		return new GIISS203Page(driver);
	}
	
	public GIISS203Page updateChanges() {
		driver.findClickableElement(updateBtnLocator).click();
		LOGGER.info("'Update' button clicked.");
		
		if(messageOverlay.getMessageType().contains("SUCCESS") ||
				messageOverlay.getMessageType().contains("INFORMATION")) {
			LOGGER.info("Message prompt displayed.");
			messageOverlay.clickOk();
		}
		
		return new GIISS203Page(driver);
	}
	
	public GIISS076Page dtAddIntm() {
		driver.findElement(addTabLocator).click();
		
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page dtEditIntm() {
		driver.findElement(editTabLocator).click();
		
		return new GIISS076Page(driver);
	}

}
