package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Multicity extends FlightTab {

	public Multicity(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="flight-departing-single-hp-flight")
	WebElement departing;
	
	@FindBy(id="flight-2-origin-hp-flight")
	WebElement flight2FlyingFrom;
	
	@FindBy(id="flight-2-destination-hp-flight")
	WebElement flight2FlyingTo;
	
	@FindBy(id="flight-2-departing-hp-flight")
	WebElement flight2Departing;


	public void enterDeparting(String textDeparting) {
		departing.sendKeys(textDeparting);
	}
	
	public void enterFlight2FlyingFrom(String text) {
		flight2FlyingFrom.sendKeys(text);

	}
	
	public void enterFlight2FlyingTo(String text) {
		flight2FlyingTo.sendKeys(text);

	}

	public void enterFlight2Departing(String text) {
		flight2Departing.sendKeys(text);

	}
	
}
