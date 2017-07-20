package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Roundtrip extends FlightTab{

	public Roundtrip(WebDriver driver, ExtentTest test) {
		super(driver, test);
		// TODO Auto-generated constructor stub
	}
	
	By departingRoundtrip = By.id("flight-departing-hp-flight");
	By returning = By.id("flight-returning-hp-flight");
	
	public void enterDeparting(String textDeparting) {
		driver.findElement(departingRoundtrip).sendKeys(textDeparting);
		test.log(LogStatus.INFO, "To Departing To put: " + textDeparting);
	}
	
	public void enterReturning(String textReturning) {
		driver.findElement(returning).sendKeys(textReturning);
		test.log(LogStatus.INFO, "To Returing To put: " + textReturning);
	}
}
