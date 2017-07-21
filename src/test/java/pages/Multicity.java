package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Multicity extends FlightTab {

	public Multicity(WebDriver driver, ExtentTest test) {
		super(driver, test);

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "flight-departing-single-hp-flight")
	WebElement departing;

	@FindBy(id = "flight-2-origin-hp-flight")
	WebElement flight2FlyingFrom;

	@FindBy(id = "flight-2-destination-hp-flight")
	WebElement flight2FlyingTo;

	@FindBy(id = "flight-2-departing-hp-flight")
	WebElement flight2Departing;

	public void enterDeparting(String text) {
		departing.sendKeys(text);
		test.log(LogStatus.INFO, "To 'Departing' entered: " + text);

	}

	public void enterFlight2FlyingFrom(String text) {
		flight2FlyingFrom.sendKeys(text);
		test.log(LogStatus.INFO, "To 'Dlight 2 Flying From' entered: " + text);

	}

	public void enterFlight2FlyingTo(String text) {
		flight2FlyingTo.sendKeys(text);
		test.log(LogStatus.INFO, "To 'Flight 2 Flying To' entered: " + text);

	}

	public void enterFlight2Departing(String text) {
		flight2Departing.sendKeys(text);
		test.log(LogStatus.INFO, "To 'Flight 2 Departing' entered: " + text);

	}

}
