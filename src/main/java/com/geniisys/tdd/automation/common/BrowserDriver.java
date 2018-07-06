package com.geniisys.tdd.automation.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public final class BrowserDriver implements WebDriver {

	private final Logger log = LogManager.getLogger(BrowserDriver.class.getName());
	
	private WebDriver driver;
	private WebElement element;
	
	private String driverPath;
	private int webDriverWaitTimeOut;
	
	private static final long TIMEOUT = 10;
	private static final long POLLING_TIME = 1;
	
	public BrowserDriver(String browserName) {
		this.driver = createDriver(browserName);
	}
	
	private WebDriver createDriver(String browserName) {
		Properties prop  = new Properties();
		
		try {
			prop.load(new FileInputStream("C:/SELENIUM-AUTOMATION/CONFIG/webdriver.properties"));
		} catch(IOException e) {
			log.error(e);
		}
		
		driverPath = prop.getProperty("path");
		webDriverWaitTimeOut = Integer.valueOf(prop.getProperty("timeout"));
		
		if("FIREFOX".equalsIgnoreCase(browserName)) {
			return firefoxDriver();
		} else if("CHROME".equalsIgnoreCase(browserName)) {
			return chromeDriver();
		} else {
			return null;
		}
	}
	
	private WebDriver firefoxDriver() {
		String geckoDriverPath = driverPath + "geckodriver.exe";
		
		try {
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			return new FirefoxDriver();
		} catch(IllegalStateException e) {
			log.error("The driver executable does not exist: " + geckoDriverPath);
			throw e;
		}
	}
	
	private WebDriver chromeDriver() {
		String chromeDriverPath = driverPath + "chromedriver.exe";
		
		try {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			return new ChromeDriver();
		} catch(IllegalStateException e) {
			log.error("The driver executable does not exist: " + chromeDriverPath);
			throw e;
		}
	}
	
	public WebDriver driver() {
		return this.driver;
	}
	
	@Override
	public String getCurrentUrl() {
		return driver().getCurrentUrl();
	}
	
	@Override
	public String getTitle() {
		return driver().getTitle();
	}
	
	@Override
	public List<WebElement> findElements(By locator) {
		return driver().findElements(locator);
	}
	
	@Override
	public WebElement findElement(By locator) {
		element = new WebDriverWait(driver(), webDriverWaitTimeOut)
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		scrollIntoView(element);
		
		return element;
	}
	
	public WebElement findElement(By locator, long timeOut) {
		element = new WebDriverWait(driver(), timeOut)
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		scrollIntoView(element);
		
		return element;
	}
	
	public WebElement findClickableElement(By locator) {
		element = new WebDriverWait(driver(), webDriverWaitTimeOut)
					.until(ExpectedConditions.elementToBeClickable(locator));
			
		scrollIntoView(element);
		
		return element;
	}
	
	public WebElement findHiddenElement(By locator) {
		element = new WebDriverWait(driver(), webDriverWaitTimeOut)
					.until(ExpectedConditions.presenceOfElementLocated(locator));
			
		scrollIntoView(element);
		
		return element;
	}
	
	public WebElement findHiddenElement(By locator, long timeOut) {
		element = new WebDriverWait(driver(), timeOut)
					.until(ExpectedConditions.presenceOfElementLocated(locator));
			
		scrollIntoView(element);
		
		return element;
	}
	
	@Override
	public String getPageSource() {
		return driver().getPageSource();
	}
	
	@Override
	public void close() {
		driver().close();
	}
	
	@Override
	public void quit() {
		driver().quit();
	}
	
	@Override
	public Set<String> getWindowHandles() {
		return driver().getWindowHandles();
	}
	
	@Override
	public String getWindowHandle() {
		return driver().getWindowHandle();
	}
	
	@Override
	public TargetLocator switchTo() {
		return driver().switchTo();
	}
	
	@Override
	public Navigation navigate() {
		return driver().navigate();
	}
	
	@Override
	public Options manage() {
		return driver().manage();
	}
	
	@Override
	public void get(String url) {
		driver().get(url);
	}
	
	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void takeScreenShot(String testName) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
		Date date = new Date();
		String sysdate = dateFormat.format(date);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(src, new File("C:/SELENIUM-AUTOMATION/SCREENSHOTS/" + testName + " "+ sysdate + ".png"));
		} catch(IOException e) {
			log.error(e);
		}
	}
	
	public FluentWait<BrowserDriver> fluentlyWait() {
		FluentWait<BrowserDriver> wait = new FluentWait<>(this);
		
		wait = wait.withTimeout(TIMEOUT, TimeUnit.SECONDS)
				   .pollingEvery(POLLING_TIME, TimeUnit.SECONDS)
				   .ignoring(NoSuchElementException.class);
		
		return wait;
	}

}
