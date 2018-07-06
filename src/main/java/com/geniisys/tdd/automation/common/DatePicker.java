package com.geniisys.tdd.automation.common;

import org.openqa.selenium.By;

import ru.yandex.qatools.htmlelements.element.Select;

public class DatePicker {
	
	private BrowserDriver driver;
	
	private final By monthLovLocator = By.xpath("//select[@id='scwMonths']");
	private final By yearLovLocator = By.xpath("//select[@id='scwYears']");
	
	public DatePicker(BrowserDriver driver) {
		this.driver = driver;
	}
	
	// Sample date format ["Jan-01-2018" or "Jan/01/2018/"] day should be two digit
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
		return date.substring(6);
	}
	
	private String extractMonth(String date) {
		Integer month = Integer.valueOf(date.substring(0, 2));
		String monthString = null;
		
		switch(month) {
		case 1:
			monthString = "Jan";
			break;
		case 2:
			monthString = "Feb";
			break;
		case 3:
			monthString = "Mar";
			break;
		case 4:
			monthString = "Apr";
			break;
		case 5:
			monthString = "May";
			break;
		case 6:
			monthString = "Jun";
			break;
		case 7:
			monthString = "Jul";
			break;
		case 8:
			monthString = "Aug";
			break;
		case 9:
			monthString = "Sep";
			break;
		case 10:
			monthString = "Oct";
			break;
		case 11:
			monthString = "Nov";
			break;
		case 12:
			monthString = "Dec";
			break;
		}
		
		return monthString;
	}
	
	private Integer extractDay(String date) {
		return  Integer.valueOf(date.substring(3, 5));
	}
 
}
