package com.expedia.owntests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageclasses.Roundtrip;
import pageclasses.OneWay;
import pageclasses.Multicity;

public class FlightsBookmark {
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;
	private Roundtrip rt;
	private OneWay ow;
	private Multicity mc;

	@BeforeClass
	public void beforeClass() {
		report = new ExtentReports("E://Development//FlightsTabTest.html");
		test = report.startTest("Verify Welcome Text");

		System.setProperty("webdriver.chrome.driver",
				"E://Development//workspace - Mariusz//Selenium//chromedriver.exe");
	}

	@AfterClass
	public void afterClass() throws Exception {
		test.log(LogStatus.PASS, "Test passed");
		Thread.sleep(2000);
		driver.quit();
		test.log(LogStatus.INFO, "Browser Ended...");
		report.endTest(test);
		report.flush();
	}

	@BeforeMethod
	public void beforeMethod() {

		driver = new ChromeDriver();
		
		rt = new Roundtrip(driver, test);
		ow = new OneWay(driver, test);

		baseUrl = "https://www.expedia.com/";
		test.log(LogStatus.INFO, "Browser Started...");

		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Window is maximize...");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web application opened...");

		rt.clickFlightTab();
	}

	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
	@Test
	public void RoundtripTest() {
		
		rt.clickRoundtripTab();
		rt.enterFlyingFrom("New York");
		rt.enterFlyingTo("Chicago");
		rt.enterDeparting("10/24/2017");
		rt.enterReturning("10/30/2017");
		rt.enterAdults("2");
		rt.enterChildren("0");
		rt.clickAdvancedOption();
		rt.chosePreferredClass("Business");
		rt.clickSearchButton();

		WebElement verificationText = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);

			verificationText = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title-city-text']")));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		Assert.assertTrue(verificationText != null);
		test.log(LogStatus.PASS, "Verifield verificationText");
	}

	@Test
	public void oneWayTest() {
		
		ow.clickOneWayTab();
		ow.enterFlyingFrom("New York");
		ow.enterFlyingTo("Chicago");
		ow.enterDeparting("10/24/2017");
		ow.enterAdults("2");
		ow.enterChildren("0");
		ow.clickAdvancedOption();
		ow.chosePreferredClass("Business");
		ow.clickSearchButton();

		WebElement verificationText = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);

			verificationText = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title-city-text']")));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		Assert.assertTrue(verificationText != null);
		test.log(LogStatus.PASS, "Verifield verificationText");
	}
	
	/*@Test
	public void multicityTest() throws InterruptedException {

		mc.clickMulticityTab();
		mc.enterFlyingFrom("New York");
		mc.enterFlyingTo("Chicago");
		mc.enterDeparting("10/24/2017");
		mc.enterAdults("2");
		mc.enterChildren("0");
		mc.enterFlight2FlyingFrom("Chicago");
		mc.enterFlight2FlyingTo("Warsaw");
		mc.enterFlight2Departing("10/26/2017");
		mc.clickAdvancedOption();
		mc.chosePreferredClass("Business");
		mc.clickSearchButton();

		WebElement verificationText = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);

			verificationText = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title-city-text']")));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		Assert.assertTrue(verificationText != null);
		test.log(LogStatus.PASS, "Verifield verificationText");
	}*/
}
