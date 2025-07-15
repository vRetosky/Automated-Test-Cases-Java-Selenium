package Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.Assert;


public class DMT_LoginTest {

	WebDriver driver;
	String MainPage = ("http://localhost/dmt/login.php");
	String validEmail = "validuser1@mail.com";
	String validPass = "!Password!3";
	String invalidEmail = "user123@mail.com";
	String invalidPass = "PaSSword1234";
	

	@BeforeClass
	public void SetUp() { //Set up the ChromeDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test(priority = 1) //Testing login attempt with valid email and invalid password
	public void validEmail_invalidPassword() {
		driver.get(MainPage); //Open the web page
		WebElement validMail = driver.findElement(By.name("email")); //Finding element by name
		validMail.sendKeys(validEmail); //Entering value in the text field
		WebElement invalidPassword = driver.findElement(By.name("password")); //Finding element by name
		invalidPassword.sendKeys(invalidPass); // Entering value in the text field
		driver.findElement(By.id("submit")).click(); //Click the submit button
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Set a wait interval
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message p"))); //After clicking the button, wait until an element is displayed	
		Assert.assertEquals(errorMessage.getText(),"Wrong Password","Test Failed: Wrong Password"); //Compare the expected and the actual value
	}
	
	@Test(priority = 2) //Testing login attempt with invalid email and invalid password
	public void invalidEmail_invalidPassword() {
		driver.get(MainPage); //Open the web page
		WebElement invalidMail = driver.findElement(By.name("email")); //Finding element by name
		invalidMail.sendKeys(invalidEmail); //Enters a value in the text field
		WebElement invalidPassword = driver.findElement(By.name("password")); //Finding element by name
		invalidPassword.sendKeys(invalidPass); //Enters a value in the text field
		driver.findElement(By.id("submit")).click(); //Click the submit button
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Set a wait interval
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message p"))); //After clicking the button, wait until an element is displayed
		Assert.assertEquals(errorMessage.getText(),"Wrong Email or Password","Test Failed: Wrong Email or Password"); //Compare the expected and the actual value
	}
	
	@Test(priority = 3) //Testing login attempt with invalid email and valid password
	public void invalidEmail_validPassword() {
		driver.get(MainPage); //Open the web page
		WebElement invalidMail = driver.findElement(By.name("email")); //Finding element by name
		invalidMail.sendKeys(invalidEmail); //Enters a value in the text field
		WebElement validPassword = driver.findElement(By.name("password")); //Finding element by name
		validPassword.sendKeys(validPass); //Enters a value in the text field
		driver.findElement(By.id("submit")).click(); //Click the submit button
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Set a wait interval
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message p"))); //After clicking the button, wait until an element is displayed
		Assert.assertEquals(errorMessage.getText(),"Wrong Email or Password","Test Failed: Wrong Email or Password"); //Compare the expected and the actual value 
	}
	
	@Test(priority = 4) //Testing login attempt with valid login credentials
	public void ValidLogin() {
		driver.get(MainPage); //Open the web page
		WebElement validMail = driver.findElement(By.name("email")); //Finding element by name
		validMail.sendKeys(validEmail); //Enters a value in the text field
		WebElement validPassword = driver.findElement(By.name("password")); //Finding element by name
		validPassword.sendKeys(validPass); //Enters a value in the text field
		driver.findElement(By.id("submit")).click(); //Click the submit button
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Set wait interval
		WebElement welcomeMessage = driver.findElement(By.xpath("//center[contains(text(),'Welcome')]")); //Find a web element
		Assert.assertTrue(welcomeMessage.getText().contains("Welcome")); //Compare the expected and the actual value 		
	}
	
	@Test(priority = 5, dependsOnMethods = {"ValidLogin"}) //Testing Logout method
	public void testLogout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //Set wait interval
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#dropdownMenuLink"))); //Find a dropdown menu
		dropdown.click(); //Click the dropdown menu
		WebElement logoutlink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='logout.php']"))); //Find an element from the drop down menu
		logoutlink.click(); //Click the logout link
		WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
		Assert.assertTrue(loginBtn.isDisplayed(), "Test failed the Login page should be displayed after logout"); //Check if the expexted element is displayed
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
