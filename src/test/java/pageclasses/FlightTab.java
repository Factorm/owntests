package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FlightTab {

	protected WebDriver driver = null;

	public FlightTab(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "tab-flight-tab-hp")
	WebElement flightTab;

	@FindBy(id = "flight-type-roundtrip-label-hp-flight")
	WebElement roundtripTab;

	@FindBy(id = "flight-type-one-way-label-hp-flight")
	WebElement oneWayTab;

	@FindBy(id = "flight-type-multi-dest-hp-flight")
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

	/*
	 * By flightTab = By.id("tab-flight-tab-hp"); By roundtripTab =
	 * By.id("flight-type-roundtrip-label-hp-flight"); By oneWayTab =
	 * By.id("flight-type-one-way-label-hp-flight"); By multicityTab =
	 * By.id("flight-type-multi-dest-hp-flight"); By flyingFrom =
	 * By.id("flight-origin-hp-flight"); By flyingTo =
	 * By.id("flight-destination-hp-flight"); By adults =
	 * By.id("flight-adults-hp-flight"); By children =
	 * By.id("flight-children-hp-flight"); By advancedOptions =
	 * By.id("flight-advanced-options-hp-flight"); By preferredCLass =
	 * By.id("flight-advanced-preferred-class-hp-flight"); By searchButton =
	 * By.xpath("//section[@id='section-flight-tab-hp']//button[@type='submit']"
	 * );
	 */

	public void clickFlightTab() {
		flightTab.click();

	}

	public void clickRoundtripTab() {
		roundtripTab.click();

	}

	public void clickOneWayTab() {
		oneWayTab.click();

	}

	public void clickMulticityTab() {
		multicityTab.click();

	}

	public void enterFlyingFrom(String textFrom) {
		flyingFrom.sendKeys(textFrom);

	}

	public void enterFlyingTo(String textTo) {
		flyingTo.sendKeys(textTo);

	}

	public void enterAdults(String textAdults) {
		adults.sendKeys(textAdults);

	}

	public void enterChildren(String textChildren) {
		children.sendKeys(textChildren);

	}

	public void clickAdvancedOption() {
		advancedOptions.click();

	}

	public void chosePreferredClass(String chose) {
		WebElement element = preferredClass;
		List<WebElement> lists = element.findElements(By.tagName("option"));

		for (WebElement list : lists) {
			if (list.getText().equals(chose)) {
				list.click();
			}
		}

	}

	public void clickSearchButton() {
		searchButton.click();

	}
}
