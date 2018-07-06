package com.geniisys.tdd.automation.common;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;

import ru.yandex.qatools.htmlelements.element.Select;

public class DatePicker {
	
	private BrowserDriver driver;
	
	private final By monthLovLocator = By.xpath("//select[@id='scwMonths']");
	private final By yearLovLocator = By.xpath("//select[@id='scwYears']");
	
	private static final int YYYY_SUBSTR = 6;
	private static final int MM_SUBSTR = 2;
	private static final int DD_START_SUBSTR = 3;
	private static final int DD_END_SUBSTR = 5;
	
	public DatePicker(BrowserDriver driver) {
		this.driver = driver;
	}
	
	// Sample date format ["Jan-01-2018" or "Jan/01/2018"] day should be two digit
	public void setDate(By locator, String date) {
		driver.findClickableElement(locator).click();
		setMonth(extractMonth(date));
		setYear(extractYear(date));
		setDay(extractDay(date).toString());
	}
	
	public void setMonth(String month) {
		Select monthLov = new Select(driver.findElement(monthLovLocator));
		monthLov.click();
		monthLov.selectByValue(month);
	}
	
	public void setDay(String day) {
		driver.findElement(By.xpath("//td[@class='scwCells' and contains(text(), '" +day+ "')]")).click();
	}
	
	public void setYear(String year) {
		Select yearLov = new Select(driver.findElement(yearLovLocator));
		yearLov.click();
		yearLov.selectByValue(year);
	}
	
	private String extractYear(String date) {
		return date.substring(YYYY_SUBSTR);
	}
	
	private String extractMonth(String date) {
		Integer month = Integer.valueOf(date.substring(0, MM_SUBSTR));
		
		return Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
	}
	
	private Integer extractDay(String date) {
		return  Integer.valueOf(date.substring(DD_START_SUBSTR, DD_END_SUBSTR));
	}
 
}
