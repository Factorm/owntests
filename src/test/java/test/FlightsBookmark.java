package test;

import java.io.IOException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import extentreports.ExtentManager;
import pages.Multicity;
import pages.OneWay;
import pages.Roundtrip;
import utilities.BrowserFactory;
import utilities.Screenshots;

public class FlightsBookmark {

	private WebDriver driver;

	Roundtrip rt;
	OneWay ow;
	Multicity mc;

	ExtentReports report;
	ExtentTest test;

	@BeforeMethod
	public void beforeMethod(Method method) {
		report = ExtentManager.getInstance();
		test = report.startTest(this.getClass().getSimpleName() + " :: " + method.getName());

		driver = BrowserFactory.startBrowser("chrome", "https://www.expedia.com/");
		test.log(LogStatus.INFO, "Browser is started (Window: maximized, ImplicitlyWait: 10 SECONDS");

	}

	@AfterMethod
	public void afterMethod(ITestResult testResult, Method method) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, testResult.getTestName() + " Failed", imagePath);
		} else {
			test.log(LogStatus.PASS, this.getClass().getSimpleName() + " :: " + method.getName() + " Passed");
		}
		driver.quit();
		report.endTest(test);
		report.flush();
	}

	@AfterClass
	public void afterClass() {
		report.close();
	}

	@Test(priority = 0)
	public void RoundtripTest() {

		rt = new Roundtrip(driver, test);

		rt.clickFlightTab();
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

		Assert.assertTrue(checkVerificationText());

	}

	@Test(priority = 1)
	public void oneWayTest() {

		ow = new OneWay(driver, test);

		ow.clickFlightTab();
		ow.clickOneWayTab();
		ow.enterFlyingFrom("New York");
		ow.enterFlyingTo("Chicago");
		ow.enterDeparting("10/24/2017");
		ow.enterAdults("2");
		ow.enterChildren("0");
		ow.clickAdvancedOption();
		ow.chosePreferredClass("Business");
		ow.clickSearchButton();

		Assert.assertTrue(checkVerificationText());
	}

	@Test(priority = 2)
	public void multicityTest() {

		mc = new Multicity(driver, test);

		mc.clickFlightTab();
		mc.clickMulticityTab();
		mc.enterFlyingFrom("New York");
		mc.enterFlyingTo("Chicago");
		mc.enterDeparting("10/24/2017");
		mc.enterAdults("2");
		mc.enterChildren("0");
		mc.enterFlight2FlyingFrom("Chicago");
		mc.enterFlight2FlyingTo("Warsaw, Poland");
		mc.enterFlight2Departing("10/26/2017");
		mc.clickAdvancedOption();
		mc.chosePreferredClass("Business");
		mc.clickSearchButton();

		Assert.assertTrue(checkVerificationText());
	}

	public boolean checkVerificationText() {
		WebElement verificationText = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);

			verificationText = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title-city-text']")));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		return verificationText != null;
	}
}
