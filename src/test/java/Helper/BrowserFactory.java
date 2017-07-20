package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver startBrowser(String browserName, String url) {

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E://Development//workspace - Mariusz//Selenium//chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"E://Development//workspace - Mariusz//Selenium//geckodriver.exe");

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {

			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.get(url);

		return driver;
	}

}
