package com.expedia.owntests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pageclasses.HomePage;

public class FlightsTabTest {
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;
	private HomePage hp;
	

	@BeforeClass
	public void beforeClass() {
		report = new ExtentReports("E://Development//FlightsTabTest.html");
		test = report.startTest("Verify Welcome Text");
		
		System.setProperty("webdriver.chrome.driver", "E://Development//workspace - Mariusz//Selenium//chromedriver.exe");
		
		driver = new ChromeDriver();
		hp = new HomePage(driver, test);
		baseUrl = "https://www.expedia.com/";
		test.log(LogStatus.INFO, "Browser Started...");
		
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Window is maximize...");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web application opened...");
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
	

	@Test
	public void test1() {
		hp.clickFlightTab();
		hp.clickRoundtripTab();
		hp.enterFlyingFrom("Now York");
		hp.enterFlyingTo("Chicago");
		hp.enterDeparting("10/24/2017");
		hp.enterReturning("10/30/2017");
		hp.enterAdults("2");
		hp.enterChildren("0");
	}
}
