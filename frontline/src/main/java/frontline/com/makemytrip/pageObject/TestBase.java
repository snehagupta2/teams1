package frontline.com.makemytrip.pageObject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestBase {

	public WebDriver driver;

	public TestBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Login navigateTo() {
		driver.navigate().to("https://www.makemytrip.com/");
		// MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday
		assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday", driver.getTitle());
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		return new Login(driver);
	}
}
