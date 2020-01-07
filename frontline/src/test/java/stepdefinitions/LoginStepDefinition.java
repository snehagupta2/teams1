package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frontline.com.makemytrip.pageObject.FlightListPage;
import frontline.com.makemytrip.pageObject.HomePage;
import frontline.com.makemytrip.pageObject.Login;
import frontline.com.makemytrip.pageObject.TestBase;

public class LoginStepDefinition {

	private static WebDriver driver = null;
	private Login login;
	private HomePage homePage;
	private FlightListPage flightListPage;
	String chromeExePath = "C:\\Users\\preeti.saxena\\Documents\\Frontline_Assignment\\chromedriver_win32\\chromedriver.exe";

	@Before
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		driver = new ChromeDriver();
		login = new Login(driver);
		homePage = new HomePage(driver);
		flightListPage = new FlightListPage(driver);
	}

	// @After
	public void tearDown() {
		driver.quit();
	}

	@Given("^I open MakeMyTrip website$")
	public void open_makeMyTrip_website() {
		login.navigateTo();
	}

	@When("^enter userId and Password$")
	public void enter_userId_password() throws InterruptedException {
		login.enterUserNamePassword("makemytrip223@gmail.com", "Project@223");
	}

	@Then("^I click on login button$")
	public void verifyLogin() throws InterruptedException {
		// homePage.verifyLogin();
		login.clickOnLoginButton();
	}

	@Given("^I am on MakeMyTrip Home Page$")
	public void makeMyTripHomePage() throws InterruptedException {
		homePage.verifyUserLogined("makemytrip223@gmail.com");
	}

	@When("^I select Source and destination and date$")
	public void selectSourceAndDestination() throws InterruptedException {
		homePage.selectSourceDestinationAndDate();
	}

	@Then("^I got list of flights$")
	public void allFlightsList() throws InterruptedException {
		homePage.clickSearch();
	}
	
	@Given("I am on list of flights page")
	public void flightListPage() throws InterruptedException {
		flightListPage.listOfFlights();
	}
	
	@When("^I select minimum fare flight")
	public void selectMinimumFareFlight() throws InterruptedException {
		flightListPage.selectMinimumFareFlight();
	}
	
	@Then("I am on flight booking page")
	public void flightBookingPage() {
		System.out.println("Flight booking");
	}
}
