package com.test.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import com.test.qa.ExtentReportListener.ExtentReporterNG;

public class TestBase {

	public static  WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	

	public static ExtentReporterNG ex;
	
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/test" + "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		String browserDriverpath=System.getProperty("user.dir");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",browserDriverpath+"\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "Path need to give here");
			driver = new FirefoxDriver();
		}

		//e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		//eventListener = new WebEventListener();
		//e_driver.register(eventListener);
		//driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(prop.getProperty("url"));

	}

	public static void click(WebElement Locator) throws IOException {
		try {
			Locator.click();
		} catch (Exception e) {
			takeScreenshot("click failed");
		}


	}

	public static void typeText(WebElement Locator, String ExcelTestData) throws IOException {
		try {
			Locator.sendKeys(ExcelTestData);
		} catch (Exception e) {
			takeScreenshot("Failed");
		}


	}

	public static void selectByVisibleText(WebElement Locator, String ExcelTestData, String DropdownType) throws IOException {
		try {
			Select drpState = new Select(Locator);
			drpState.selectByVisibleText(ExcelTestData);
		} catch (Exception e) {
			takeScreenshot(DropdownType);
		}


	}

	public static void selectByValue(WebElement Locator, String ExcelTestData, String DropdownType) throws IOException {
		try {
			Select drpState = new Select(Locator);
			drpState.selectByValue(ExcelTestData);
		} catch (Exception e) {
			takeScreenshot(DropdownType);
		}


	}

	public static void selectByIndex(WebElement Locator, int IndexNum, String DropdownType) throws IOException {
		try {
			Select drpState = new Select(Locator);
			drpState.selectByIndex(IndexNum);
		} catch (Exception e) {
			takeScreenshot(DropdownType);
		}


	}



	public static void ExplicitWait(WebElement Locator, int timesec) {

		try {
			WebDriverWait wait = new WebDriverWait(driver,timesec);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) Locator));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void takeScreenshot(String fileName) throws IOException{
		// Take screenshot and store as a file format
		//File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		//FileUtils.copyFile(src, new File("user.dir"+"\\screenshots" + fileName +".png"));
		
        ExtentReporterNG reports = new ExtentReporterNG();
		
		reports.test.addScreenCapture("user.dir"+"\\screenshots" + fileName +".png");
		
		

	}


















}
