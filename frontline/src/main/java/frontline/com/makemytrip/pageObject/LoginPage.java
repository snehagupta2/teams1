package frontline.com.makemytrip.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	@FindBy(xpath ="//i[@class=\"wewidgeticon we_close\"]")
	static WebElement closeButton;
	
	@FindBy(xpath="//*[@class=\"makeFlex column flexOne whiteText latoBold\"]/p")
	static WebElement loginButton;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath="//button[@class='capText font16']")
	WebElement continueButton;
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		  WebDriver driver; 
		  
		  
		  String chromeExePath = "C:\\Users\\preeti.saxena\\Documents\\Frontline_Assignment\\chromedriver_win32\\chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver", chromeExePath);
		  
		  
		  driver = new ChromeDriver();
		  driver.get("https://www.makemytrip.com/");
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  Thread.sleep(2);
		  driver.manage().window().maximize();
		  driver.findElement(By.xpath("//p[text()=' Login or Create Account']")).click();
		  Thread.sleep(5);
		  driver.findElement(By.xpath("//input[@id='username']")).sendKeys("makemytrip223@gmail.com");
		  Thread.sleep(3000);
		  
		
		  WebElement we = driver.findElement(By.xpath("//button[@data-cy='continueBtn']"));
		  
		
		/*
		 * do { new Actions(driver).moveToElement(we).click().build().perform(); }
		 * while(we.isDisplayed());
		 */
		 
		 
		
		  for(int i=0;i<=2;i++) { try { new
		  Actions(driver).moveToElement(we).click().build().perform(); 
		  } catch
		  (Exception e) { break; } }
		 
		  Thread.sleep(2000);
		  // Enter Password
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Project@223");
		  
		  Thread.sleep(2000);
		  // Click on Login
		  driver.findElement(By.xpath("//span[text()='Login']")).click();
		  
		  
		  // Search For Flights From Source To Destination
		  Thread.sleep(2000);
		  //WebElement from = driver.findElement(By.xpath("//label[@for='fromCity']"));
		  WebElement from = driver.findElement(By.id("fromCity"));
		  from.click();
		  
		  Thread.sleep(5000);
		 // WebElement fromValue = driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']"));
		  WebElement fromValue = driver.findElement(By.xpath("//input[@placeholder='From']"));
		  fromValue.sendKeys("Delhi");
		  
		  Thread.sleep(4000);
		  List<WebElement> places = driver.findElements(By.xpath("//div[contains(@class,'autocomplePopup')]//p[contains(@class,'blackText')]"));
		  for(WebElement ele: places) {
			  System.out.println(ele.getText());
			  if(ele.getText().contains("Delhi")) {
				  ele.click();
				  break;
			  }
		  }
		  
		  Thread.sleep(3000);
		  WebElement toValue = driver.findElement(By.xpath("//input[@placeholder='To']"));
		  toValue.sendKeys("Mumbai");
		  
		  Thread.sleep(4000);
		  List<WebElement> destination = driver.findElements(By.xpath("//div[contains(@class,'autocomplePopup')]//p[contains(@class,'blackText')]"));
		  for(WebElement ele: destination) {
			  System.out.println(ele.getText());
			  if(ele.getText().contains("Mumbai")) {
				  ele.click();
				  break;
			  }
		  }
		  
		  Thread.sleep(3000);
		  List<WebElement> dates = driver.findElements(By.xpath("//div[@class='DayPicker-Months']/child::div[1]/div[3]//p"));
		  
		  for(WebElement date : dates) {
			  if(date.getText().equals("30")) {
				  date.click();
				  break;
			  }
		  }
		/*
		 * dates.forEach(a -> {if(a.getText().equals("30")) a.click();break;});
		 */
//		  dates.forEach(a -> System.out.println(a.getText()));
		  
		  Thread.sleep(3000);
		
		  
		  WebElement searchButton = driver.findElement(By.xpath("//a[text()='Search']"));
		  searchButton.click();
		 
		  Thread.sleep(3000);
		  
		 WebElement priceDown = driver.findElement(By.xpath("//span[@class='pointer']//span[text()='Price']/following-sibling::span"));
		 if(priceDown.getAttribute("class").contains("up")) {
			 priceDown.click();
		 }
		 
		 Thread.sleep(3000);
		 List<WebElement> bookNowButton = driver.findElements(By.xpath("//button[text()='Book Now']"));
		 bookNowButton.get(0).click();
	
		 
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\preeti.saxena\\Documents\\Frontline_Assignment\\chromedriver_win32\\chromedriver.exe"
		 * ); WebDriver driver = new ChromeDriver();
		 */
		 
	}
}
