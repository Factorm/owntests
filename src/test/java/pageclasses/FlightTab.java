package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FlightTab {

	ExtentTest test;
	protected WebDriver driver = null;
	// public static WebElement element = null;

	public FlightTab(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	By flightTab = By.id("tab-flight-tab-hp");
	By roundtripTab = By.id("flight-type-roundtrip-label-hp-flight");
	By oneWayTab = By.id("flight-type-one-way-label-hp-flight");
	By multicityTab = By.id("flight-type-multi-dest-label-hp-flight");
	By flyingFrom = By.id("flight-origin-hp-flight");
	By flyingTo = By.id("flight-destination-hp-flight");
	By adults = By.id("flight-adults-hp-flight");
	By children = By.id("flight-children-hp-flight");
	By advancedOptions = By.id("flight-advanced-options-hp-flight");
	By preferredCLass = By.id("flight-advanced-preferred-class-hp-flight");
	By searchButton = By.xpath("//section[@id='section-flight-tab-hp']//button[@type='submit']");

	public void clickFlightTab() {
		driver.findElement(flightTab).click();
		test.log(LogStatus.INFO, "FlightTab clicked");
	}

	public void clickRoundtripTab() {
		driver.findElement(roundtripTab).click();
		test.log(LogStatus.INFO, "RoundtripTab clicked");
	}

	public void clickoneWayTab() {
		driver.findElement(oneWayTab).click();
		test.log(LogStatus.INFO, "OneWayTab clicked");
	}
	
	public void clickMulticityTab() {
		driver.findElement(multicityTab).click();
		test.log(LogStatus.INFO, "multicityTab clicked");
	}

	public void enterFlyingFrom(String textFrom) {
		driver.findElement(flyingFrom).sendKeys(textFrom);
		test.log(LogStatus.INFO, "To Flying From put: " + textFrom);
	}

	public void enterFlyingTo(String textTo) {
		driver.findElement(flyingTo).sendKeys(textTo);
		test.log(LogStatus.INFO, "To Flying To put: " + textTo);
	}

	public void enterAdults(String textAdults) {
		driver.findElement(adults).sendKeys(textAdults);
		test.log(LogStatus.INFO, "To Adults To put: " + textAdults);
	}

	public void enterChildren(String textChildren) {
		driver.findElement(children).sendKeys(textChildren);
		test.log(LogStatus.INFO, "To Children To put: " + textChildren);
	}

	public void clickAdvancedOption() {
		driver.findElement(advancedOptions).click();
		test.log(LogStatus.INFO, "Advanced option clicked");
	}

	public void chosePreferredClass(String chose) {
		WebElement element = driver.findElement(preferredCLass);
		List<WebElement> lists = element.findElements(By.tagName("option"));

		for (WebElement list : lists) {
			if (list.getText().equals(chose)) {
				list.click();
			}
		}
		test.log(LogStatus.INFO, "Preferred class chosed");
	}

	public void clickSearchButton() {
		driver.findElement(searchButton).click();
		test.log(LogStatus.INFO, "Search button clicked");
	}
}
