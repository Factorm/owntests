package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OneWay extends FlightTab {

	public OneWay(WebDriver driver, ExtentTest test) {
		super(driver, test);

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "flight-departing-single-hp-flight")
	WebElement departing;

	public void enterDeparting(String text) {
		departing.sendKeys(text);
		test.log(LogStatus.INFO, "To 'Departing' entered: " + text);

	}
}
