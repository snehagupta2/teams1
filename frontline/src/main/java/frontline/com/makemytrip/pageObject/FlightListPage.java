package frontline.com.makemytrip.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightListPage extends TestBase {

	@FindBy(xpath = "//div[@class ='fli-intl-lhs pull-left']/div[3]/div/div")
	List<WebElement> listOfFLights;
	
	@FindBy(xpath="//span[@class='pointer']//span[text()='Price']/following-sibling::span")
	WebElement priceDown;
	
	@FindBy(xpath = "//button[text()='Book Now']")
	List<WebElement> bookNowButton;

	public FlightListPage(WebDriver driver) {
		super(driver);
	}

	public void listOfFlights() throws InterruptedException {
		Thread.sleep(9000);
		System.out.println(listOfFLights.size() + "**************");
		if (listOfFLights.size() > 5) {
			System.out.println("List Of Flights Page");
		} else {
			System.out.println("Not List of FLight Page");
		}
	}

	public void selectMinimumFareFlight() throws InterruptedException {
		Thread.sleep(5000);

		//WebElement priceDown = driver.findElement(By.xpath("//span[@class='pointer']//span[text()='Price']/following-sibling::span"));
		if (priceDown.getAttribute("class").contains("up")) {
			priceDown.click();
		}

		Thread.sleep(3000);
		//List<WebElement> bookNowButton = driver.findElements(By.xpath("//button[text()='Book Now']"));
		bookNowButton.get(0).click();
	}
}
