package com.geniisys.tdd.automation.underwriting.maintenance.intermediary.intermediary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.geniisys.tdd.automation.common.MessageOverlay;
import com.geniisys.tdd.automation.common.BrowserDriver;
import com.geniisys.tdd.automation.common.DataTable;

public class GIISS203Page {
	
	private static final Logger LOGGER = LogManager.getLogger(GIISS203Page.class);
	
	private BrowserDriver driver;
	private MessageOverlay messageOverlay;
	private DataTable dataTable;
	
	private final By homeBtnLocator = By.id("footerHome");
	
	private final By activeTagChkLocator = By.id("chkActiveTag");
	private final By intmNameTxtLocator = By.id("txtIntmName");
	private final By refIntmCdTxtLocator = By.id("txtRefIntmCd");
	private final By remarksTxtLocator = By.id("txtRemarks");
	private final By updateBtnLocator = By.id("btnUpdate");
	
	public GIISS203Page(BrowserDriver driver) {
		this.driver = driver;
		this.messageOverlay = new MessageOverlay(driver);
		this.dataTable = new DataTable(driver);
	}
	
	public GIISS203Page goToHome() {
		if(driver.findElement(homeBtnLocator, 1).isDisplayed()) {
			driver.findElement(homeBtnLocator).click();
		}
		
		return new GIISS203Page(driver);
	}
	
	public GIISS203Page selectIntmRecord() {
		dataTable.selectRecord();
		return new GIISS203Page(driver);
	}
	
	public GIISS076Page addIntmRecord() {
		dataTable.add();
		return new GIISS076Page(driver);
	}
	
	public GIISS076Page editIntmRecord() {
		dataTable.edit();
		return new GIISS076Page(driver);
	}
	
	public GIISS203Page setActiveTag(String active) {
		if("A".equals(active) && !driver.findElement(activeTagChkLocator).isSelected()) {
			driver.findClickableElement(activeTagChkLocator).click();
		} else if("I".equals(active) && driver.findElement(activeTagChkLocator).isSelected()) {
			driver.findClickableElement(activeTagChkLocator).click();
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
		driver.findElement(remarksTxtLocator).clear();
		driver.findElement(remarksTxtLocator).sendKeys(remarks);
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

}
