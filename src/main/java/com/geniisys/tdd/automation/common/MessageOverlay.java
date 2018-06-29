package com.geniisys.tdd.automation.common;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class MessageOverlay {
	
	private BrowserDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(MessageOverlay.class.getName());
	
	private static final long TIMEOUT = 10;
	private static final long POLLING_TIME = 1;
	
	private By messageOvlLocator = By.xpath("//div[starts-with(@id, 'modal_dialog') and @class='dialog']");
	private By messageTxtLocator = By.xpath("//div[starts-with(@id, 'modal_dialog') and contains(@id, 'top')]");
	private By okBtnLocator = By.xpath("//input[@id='btnMsgBoxOk']");
	
	public MessageOverlay(BrowserDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDisplayed() {
		try {
			return driver.findHiddenElement(messageOvlLocator, 1).isDisplayed();
		} catch(Exception e) {
			return false;
		}
	}
	
	public String getMessageType() {
		if(isDisplayed()) {
			return driver.findElement(messageTxtLocator).getText();
		} else {
			return "NOT DISPLAYED";
		}
	}
	
	public void clickOk() {
		waitForMessageToDisplay();
		
		driver.findClickableElement(okBtnLocator).click();
		LOGGER.info("'Ok' button clicked in the prompt.");
		
		waitForMessageToClose();
	}
	
	private void waitForMessageToDisplay() {
		fluentlyWait().until(ExpectedConditions.visibilityOfElementLocated(messageOvlLocator));
	}
	
	private void waitForMessageToClose() {
		fluentlyWait().until(ExpectedConditions.invisibilityOfElementLocated(messageOvlLocator));
		LOGGER.info("Message prompt closed.");
	}
	
	private FluentWait<BrowserDriver> fluentlyWait() {
		FluentWait<BrowserDriver> wait = new FluentWait<>(driver);
		
		wait = wait.withTimeout(TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(POLLING_TIME, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		return wait;
	}
	
}
