package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OneWay extends FlightTab {

	public OneWay(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="flight-departing-single-hp-flight")
	WebElement departing;

	public void enterDeparting(String textDeparting) {
		departing.sendKeys(textDeparting);

	}

}
