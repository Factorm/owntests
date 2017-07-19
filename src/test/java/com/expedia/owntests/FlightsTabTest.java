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

public class FlightsTabTest {
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;
	

	@BeforeClass
	public void beforeClass() {
		report = new ExtentReports("E://Development//workspace - Mariusz//TestNGTutorial//reports//logintest.html");
		test = report.startTest("Verify Welcome Text");
		
		System.setProperty("webdriver.chrome.driver", "E://Development//workspace - Mariusz//Selenium//chromedriver.exe");
		
		driver = new ChromeDriver();
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
		driver.quit();
		test.log(LogStatus.INFO, "Browser Ended...");
		report.endTest(test);
		report.flush();
	}
	

	@Test
	public void f() {
	}
}
