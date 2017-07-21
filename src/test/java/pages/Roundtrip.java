package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Roundtrip extends FlightTab {

	public Roundtrip(WebDriver driver, ExtentTest test) {
		super(driver, test);

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "flight-departing-hp-flight")
	WebElement departingRoundtrip;

	@FindBy(id = "flight-returning-hp-flight")
	WebElement returning;

	public void enterDeparting(String text) {
		departingRoundtrip.sendKeys(text);
		test.log(LogStatus.INFO, "To 'Departing' entered: " + text);

	}

	public void enterReturning(String text) {
		returning.sendKeys(text);
		test.log(LogStatus.INFO, "To 'Returning' entered: " + text);

	}
}
