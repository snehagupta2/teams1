package frontline.com.makemytrip.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

//import frontline.com.makemytrip.pageObject.Login;
//import testBase.TestBase;

public class Login extends TestBase {

	@FindBy(xpath = "//p[text()=' Login or Create Account']")
	private WebElement loginOrCreateAccount;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameTextBox;

	@FindBy(xpath = "//button[@data-cy='continueBtn']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//span[text()='Login']")
	private WebElement loginButton;

	public Login(WebDriver driver) {
		super(driver);
	}

	public void enterUserNamePassword(String userName, String password) throws InterruptedException {

		loginOrCreateAccount.click();
		Thread.sleep(2000);

		userNameTextBox.sendKeys(userName);
		Thread.sleep(3000);

		for (int i = 0; i <= 2; i++) {
			try {
				new Actions(driver).moveToElement(continueButton).click().build().perform();
			} catch (Exception e) {
				break;
			}
		}

		Thread.sleep(2000);
		passwordTextBox.sendKeys(password);
	}

	public void clickOnLoginButton() throws InterruptedException {
		Thread.sleep(2000);

		loginButton.click();
	}
}
