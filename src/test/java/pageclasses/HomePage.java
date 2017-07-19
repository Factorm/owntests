package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	ExtentTest test;
	private WebDriver driver = null;
	public static WebElement element = null;

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void clickFlightTab() {
		WebElement FlightTab = driver.findElement(By.id("tab-flight-tab-hp"));
		FlightTab.click();
		test.log(LogStatus.INFO, "FlightTab clicked");
	}

	public void clickRoundtripTab() {
		WebElement RoundtripTab = driver.findElement(By.id("flight-type-roundtrip-label-hp-flight"));
		RoundtripTab.click();
		test.log(LogStatus.INFO, "RoundtripTab clicked");
	}

	public void enterFlyingFrom(String textFrom) {
		WebElement FlyingFromBox = driver.findElement(By.id("flight-origin-hp-flight"));
		FlyingFromBox.sendKeys(textFrom);
		test.log(LogStatus.INFO, "To Flying From put: " + textFrom);
	}

	public void enterFlyingTo(String textTo) {
		WebElement FlyingToBox = driver.findElement(By.id("flight-destination-hp-flight"));
		FlyingToBox.sendKeys(textTo);
		test.log(LogStatus.INFO, "To Flying To put: " + textTo);
	}
	
	public void enterDeparting(String textDeparting) {
		WebElement DepartingBox = driver.findElement(By.id("flight-departing-hp-flight"));
		DepartingBox.sendKeys(textDeparting);
		test.log(LogStatus.INFO, "To Departing To put: " + textDeparting);
	}
	
	public void enterReturning(String textReturning) {
		WebElement ReturningBox = driver.findElement(By.id("flight-returning-hp-flight"));
		ReturningBox.sendKeys(textReturning);
		test.log(LogStatus.INFO, "To Returing To put: " + textReturning);
	}
	
	public void enterAdults(String textAdults) {
		WebElement AdultsBox = driver.findElement(By.id("flight-adults-hp-flight"));
		AdultsBox.sendKeys(textAdults);
		test.log(LogStatus.INFO, "To Adults To put: " + textAdults);
	}
	
	public void enterChildren(String textChildren) {
		WebElement ChildrenBox = driver.findElement(By.id("flight-children-hp-flight"));
		ChildrenBox.sendKeys(textChildren);
		test.log(LogStatus.INFO, "To Children To put: " + textChildren);
	}
}
