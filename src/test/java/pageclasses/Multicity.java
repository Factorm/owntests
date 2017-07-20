package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Multicity extends FlightTab {

	public Multicity(WebDriver driver, ExtentTest test) {
		super(driver, test);
		// TODO Auto-generated constructor stub
	}

	By departing = By.id("flight-departing-single-hp-flight");
	By flight2FlyingFrom = By.id("flight-2-origin-hp-flight");
	By flight2FlyingTo = By.id("flight-2-destination-hp-flight");
	By flight2Departing = By.id("flight-2-departing-hp-flight");

	public void enterDeparting(String textDeparting) {
		driver.findElement(departing).sendKeys(textDeparting);
		test.log(LogStatus.INFO, "To Departing To put: " + textDeparting);
	}
	
	public void enterFlight2FlyingFrom(String text) {
		driver.findElement(flight2FlyingFrom).sendKeys(text);
		test.log(LogStatus.INFO, "To flight2FlyingFrom To put: " + text);
	}
	
	public void enterFlight2FlyingTo(String text) {
		driver.findElement(flight2FlyingTo).sendKeys(text);
		test.log(LogStatus.INFO, "To flight2FlyingTo put: " + text);
	}

	public void enterFlight2Departing(String text) {
		driver.findElement(flight2Departing).sendKeys(text);
		test.log(LogStatus.INFO, "To flight2Departing put: " + text);
	}
	
}
