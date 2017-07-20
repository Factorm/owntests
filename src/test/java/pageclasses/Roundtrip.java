package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Roundtrip extends FlightTab{

	public Roundtrip(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="flight-departing-hp-flight")
	WebElement departingRoundtrip;
	
	@FindBy(id="flight-returning-hp-flight")
	WebElement returning;
	
	public void enterDeparting(String textDeparting) {
		departingRoundtrip.sendKeys(textDeparting);
	}
	
	public void enterReturning(String textReturning) {
		returning.sendKeys(textReturning);
	}
}
