package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.FlightsBookmark;

public class FlightTab extends FlightsBookmark {

	protected WebDriver driver = null;
	protected ExtentTest test;

	public FlightTab(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	@FindBy(id = "tab-flight-tab-hp")
	WebElement flightTab;

	@FindBy(id = "flight-type-roundtrip-label-hp-flight")
	WebElement roundtripTab;

	@FindBy(id = "flight-type-one-way-label-hp-flight")
	WebElement oneWayTab;

	@FindBy(id = "flight-type-multi-dest-label-hp-flight")
	WebElement multicityTab;

	@FindBy(id = "flight-origin-hp-flight")
	WebElement flyingFrom;

	@FindBy(id = "flight-destination-hp-flight")
	WebElement flyingTo;

	@FindBy(id = "flight-adults-hp-flight")
	WebElement adults;

	@FindBy(id = "flight-children-hp-flight")
	WebElement children;

	@FindBy(id = "flight-advanced-options-hp-flight")
	WebElement advancedOptions;

	@FindBy(id = "flight-advanced-preferred-class-hp-flight")
	WebElement preferredClass;

	@FindBy(xpath = "//section[@id='section-flight-tab-hp']//button[@type='submit']")
	WebElement searchButton;

	public void clickFlightTab() {
		flightTab.click();
		test.log(LogStatus.INFO, "Flight tab is clicked");

	}

	public void clickRoundtripTab() {
		roundtripTab.click();
		test.log(LogStatus.INFO, "Roundtrip is clicked");
	}

	public void clickOneWayTab() {
		oneWayTab.click();
		test.log(LogStatus.INFO, "One Way is clicked");

	}

	public void clickMulticityTab() {
		multicityTab.click();
		test.log(LogStatus.INFO, "Multi-City is clicked");

	}

	public void enterFlyingFrom(String text) {
		flyingFrom.sendKeys(text);
		test.log(LogStatus.INFO, "To 'Flying From' entered: " + text);

	}

	public void enterFlyingTo(String text) {
		flyingTo.sendKeys(text);
		test.log(LogStatus.INFO, "To 'Flying To' entered: " + text);

	}

	public void enterAdults(String text) {
		adults.sendKeys(text);
		test.log(LogStatus.INFO, "To 'Adults' entered: " + text);

	}

	public void enterChildren(String text) {
		children.sendKeys(text);
		test.log(LogStatus.INFO, "To 'Children' entered: " + text);

	}

	public void clickAdvancedOption() {
		advancedOptions.click();
		test.log(LogStatus.INFO, "Advanced Option is clicked");

	}

	public void chosePreferredClass(String chose) {
		List<WebElement> results = preferredClass.findElements(By.tagName("option"));

		for (WebElement result : results) {
			if (result.getText().equals(chose)) {
				result.click();
			}
		}
		test.log(LogStatus.INFO, "To 'Preferred Class' entered: " + chose);
	}

	public void clickSearchButton() {
		searchButton.click();
		test.log(LogStatus.INFO, "Search Button is clicked");

	}

}
