package com.geniisys.tdd.automation.common;

import java.util.Map;

import org.openqa.selenium.By;

public class DataTable {
	
	private BrowserDriver driver;
	
	private final By addTabLocator = By.xpath("//div[contains (@class, 'dtbl-add-btn')]");
	private final By editTabLocator = By.xpath("//div[contains (@class, 'dtbl-edit-btn')]");
	private final By intmRecordTabLocator = By.xpath("//div[contains (@class, 'tabulator-row')]");
	
	public DataTable(BrowserDriver driver) {
		this.driver = driver;
	}
	
	public void add() {
		driver.findElement(addTabLocator).click();
	}
	
	public DataTable edit() {
		driver.findElement(editTabLocator).click();
		return new DataTable(driver);
	}
	
	public DataTable delete() {
		return new DataTable(driver);
	}
	
	public DataTable refresh() {
		return new DataTable(driver);
	}
	
	public DataTable filter(Map<String, Object> filterBy) {
		return new DataTable(driver);
	}
	
	public DataTable selectRecord() {
		driver.findElement(intmRecordTabLocator).click();
		return new DataTable(driver);
	}
 
}
