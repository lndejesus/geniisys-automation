package com.geniisys.ut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.geniisys.tdd.automation.common.BrowserDriver;
import com.geniisys.tdd.automation.main.HomePage;
import com.geniisys.tdd.automation.main.LoginPage;

public abstract class BaseTest {

	protected BrowserDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(BaseTest.class.getName());
	
	private String url;
	private String username;
	private String password;
	
	protected HomePage homePage;

	@BeforeTest
	public void setUp() {
		Properties prop  = new Properties();
		
		try {
			prop.load(new FileInputStream("C:/SELENIUM-AUTOMATION/CONFIG/geniisys.properties"));
		} catch (IOException e) {
			LOGGER.error(e);
		}
		
		url = prop.getProperty("url", "http://localhost:8080/Geniisys/");
		username = prop.getProperty("username", "CPI");
		password = prop.getProperty("password", "CPI12345!");

		setDriver(new BrowserDriver("FIREFOX"));
		driver.manage().window().maximize();
		driver.get(url);

		homePage = new LoginPage(driver).loginAs(username, password);
	}

	@AfterTest
	public void breakDown() throws InterruptedException {
		driver.quit();
	}

	public BrowserDriver getDriver() {
		return driver;
	}

	public void setDriver(BrowserDriver driver) {
		this.driver = driver;
	}
	
}
