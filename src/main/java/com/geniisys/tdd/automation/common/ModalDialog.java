package com.geniisys.tdd.automation.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ModalDialog {
	
	private static final Logger LOGGER = LogManager.getLogger(ModalDialog.class.getName());
	
	private BrowserDriver driver;
	
	private By modalDialogOvlLocator = By.xpath("//div[starts-with(@id,'modal_dialog') and @class='dialogOverlay']");
	private By findFldLocator = By.xpath("//input[starts-with(@id,'modal_dialog') and contains(@id,'txtLOVFindText')]");
	private By okBtnLocator = By.xpath("//input[starts-with(@id, 'modal_dialog') and contains (@id, 'btnOk')]");
	private By returnBtnLocator = By.xpath("//input[@id='btnReturn']");
	
	public ModalDialog(BrowserDriver driver) {
		this.driver = driver;
	}
	private boolean isDisplayed() {
		return driver.findElement(modalDialogOvlLocator).isDisplayed();
	}
	
	public void searchAndSelect(String keyword) {
		if(isDisplayed()) {
			driver.findElement(findFldLocator).click();
			LOGGER.info("Find field clicked.");
			
			driver.findElement(findFldLocator).clear();
			LOGGER.info("Find field cleared.");
			
			driver.findElement(findFldLocator).sendKeys(keyword, Keys.ENTER);
			LOGGER.info("Find field value set to '" + keyword + "'.");

			driver.findElement(By.xpath("//div[starts-with(@class,'mtgInnerCell') "
					+ "and contains(text(),"
					+ " \"" + keyword + "\")]")).click();
			LOGGER.info("Record that contains text '" + keyword + "' clicked.");
			
			driver.findClickableElement(okBtnLocator).click();
			LOGGER.info("'Ok' button clicked.");
		}
		
		LOGGER.info("Prompt closed.");
	}
	
	public void exitModal() {
		if(isDisplayed()) {
			driver.findClickableElement(returnBtnLocator).click();
			LOGGER.info("'Return' button clicked.");
		}
		
		LOGGER.info("Prompt closed.");
	}
	
}
