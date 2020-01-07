package frontline.com.makemytrip.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;

public class HomePage extends TestBase {

	@FindBy(xpath = "//li[@data-cy='account']")
	private WebElement accountElement;

	@FindBy(xpath = "//p[contains(text(),'personal profile')]")
	private WebElement userNameLabel;

	@FindBy(id = "fromCity")
	private WebElement fromCity;

	@FindBy(xpath = "//input[@placeholder='From']")
	private WebElement fromValue;

	@FindBy(xpath = "//div[contains(@class,'autocomplePopup')]//p[contains(@class,'blackText')]")
	private List<WebElement> places;

	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement toValue;

	@FindBy(xpath = "//div[@class='DayPicker-Months']/child::div[1]/div[3]//p")
	private List<WebElement> dates;

	@FindBy(xpath = "//a[text()='Search']")
	private WebElement searchButton;

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void verifyUserLogined(String userName) throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(accountElement));
		accountElement.click();
		Thread.sleep(5000);
		if (userNameLabel.getText().contains(userName)) {
			//return true;
			System.out.println("User is on Login Sucessfully");
		} else {
			//return false;
			System.out.println("Some  Issuee...");
		}

	}

	public void selectSourceDestinationAndDate() throws InterruptedException {
		fromCity.click();
		Thread.sleep(5000);

		fromValue.sendKeys("Delhi");
		Thread.sleep(4000);

		for (WebElement ele : places) {
			System.out.println(ele.getText());
			if (ele.getText().contains("Delhi")) {
				ele.click();
				break;
			}
		}

		Thread.sleep(3000);
		toValue.sendKeys("Mumbai");

		Thread.sleep(4000);
		for (WebElement ele : places) {
			System.out.println(ele.getText());
			if (ele.getText().contains("Mumbai")) {
				ele.click();
				break;
			}
		}

		Thread.sleep(3000);
		List<WebElement> dates = driver
				.findElements(By.xpath("//div[@class='DayPicker-Months']/child::div[1]/div[3]//p"));

		for (WebElement date : dates) {
			if (date.getText().equals("30")) {
				date.click();
				break;
			}
		}

		Thread.sleep(3000);

	}

	public void clickSearch() throws InterruptedException {
		Thread.sleep(3000);

		WebElement searchButton = driver.findElement(By.xpath("//a[text()='Search']"));
		searchButton.click();
	}
}

/*
 * public boolean verifyUser(String strUserName) {
 * waitHelper.WaitForElementClickable(account);
 * log.info("Opening user details...."); account.click();
 * waitHelper.waitForElement(usernamelabel);
 * if(usernamelabel.getText().contains(strUserName)){ return true; } else {
 * return false; } }
 */

/*
 * @FindBy(xpath="//li[@data-cy='account']") WebElement account;
 * 
 * @FindBy(xpath="//p[contains(text(),'personal profile')]") WebElement
 * usernamelabel;
 */
