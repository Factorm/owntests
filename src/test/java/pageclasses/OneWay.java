package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OneWay extends FlightTab {

	public OneWay(WebDriver driver, ExtentTest test) {
		super(driver, test);
		// TODO Auto-generated constructor stub
	}

	By departing = By.id("flight-departing-single-hp-flight");

	public void enterDeparting(String textDeparting) {
		driver.findElement(departing).sendKeys(textDeparting);
		test.log(LogStatus.INFO, "To Departing To put: " + textDeparting);
	}

}
